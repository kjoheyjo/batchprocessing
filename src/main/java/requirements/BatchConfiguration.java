package requirements;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    
    
    @Autowired
    public DataSource dataSource;
    private StepExecutionListenerImpl stepExecutionListenerImpl;

    @Autowired
    private Environment env;
 
    @Bean(destroyMethod="")
    @JobScope
    public JdbcCursorItemReader<RMSRequirement> rdxMysqleader(DataSource dataSource) {
    	
    	
       JdbcCursorItemReader<RMSRequirement> reader = new JdbcCursorItemReader<>();
       
       
       
       
       reader.setRowMapper(BeanPropertyRowMapper.newInstance(RMSRequirement.class));
       reader.setFetchSize(5);
       String sql1="SELECT * FROM requirementMigrationStatus where status in (0,1) and type=1 limit 1";
    
   	java.sql.Connection conn = null;
       
       try {
    	   dataSource=createCommonDBDatasource();
		conn = dataSource.getConnection();
	
       Statement stmt=conn.createStatement();   
       // Executing SQL query  
       ResultSet rs=stmt.executeQuery(sql1);    
       String clientId="0";
       String reqId="0";
       while(rs.next()){    
       	clientId=rs.getString("clientId");
       	reqId=rs.getString("requirementId");
       } 
    
       final DataSource dataSource1 = createDatasource(clientId,dataSource);
       reader.setDataSource(dataSource1);
       
       
      String sql="SELECT * from Project where clientId="+clientId+" and projectId >"+reqId;
      reader.setSql(sql);
      
  	String sql2="update requirementMigrationStatus set status=1 where clientId="+clientId+" and type=1";
  	 Statement stmt2=conn.createStatement(); 
  	 stmt2.executeUpdate(sql2);
  	 rs.close();
  	 stmt.close();
  	stmt2.close();
  	//conn.close();
       } catch (Exception e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   
          
       
   	}
       
       finally {
		
	}
       
       
       return reader;
    }

	private DataSource createDatasource(String clientId, DataSource dataSource) {
		HikariConfig config = new HikariConfig();
	    HikariDataSource ds = null;
	 
	    
	       
	    
	    
	      String shardSql="select serverTag,dbName from ShardSelector s1 join ShardDetail s2 on s1.shardId=s2.shardId where clientId="+clientId;
	     	       try {
	    	   java.sql.Connection conn = dataSource.getConnection();
		
	    	   Statement   stmt=conn.createStatement();   
	       // Executing SQL query  
	    	   ResultSet rs=stmt.executeQuery(shardSql);    
	       String serverTag="0";
	       String dbName="0";
	       while(rs.next()){    
	    	   serverTag=rs.getString("serverTag");
	       	dbName=rs.getString("dbName");
	       } 
	       
		
		  
		  
		   config.setJdbcUrl(env.getProperty(serverTag).replaceAll("dname", dbName));
	        config.setUsername(env.getProperty("username"));
	        config.setPassword(env.getProperty("password"));
	        config.setMaximumPoolSize(1);
	        ds = new HikariDataSource( config );
	     	       }
	     	      catch (Exception e1) {
	     				// TODO Auto-generated catch block
	     				e1.printStackTrace();
	     			}
		return ds;
	}
	
	private DataSource createCommonDBDatasource() {
		
		HikariConfig config = new HikariConfig();
    HikariDataSource ds = null;
	
		config.setJdbcUrl(env.getProperty("spring.datasource.url"));
        config.setUsername(env.getProperty("spring.datasource.username"));
        config.setPassword(env.getProperty("spring.datasource.password"));
        config.setMaximumPoolSize(2);
        ds = new HikariDataSource( config );
        return ds;
     }

    @Bean
    public RequirementProcessor requirementProcessor() {
        return new RequirementProcessor();
    }

    @Bean
    public ItemWriter<RequirementDTO> mongoWriter() {
        return new RequirementWriter();
    }

    @Bean
    public Step step1(ItemWriter<RequirementDTO> writer, JdbcCursorItemReader<RMSRequirement> reader) {
        return stepBuilderFactory.get("step1")
                .<RMSRequirement,RequirementDTO> chunk(100)
                .reader(reader)
                .processor(requirementProcessor())
                .writer(writer).listener(new StepExecutionListenerImpl(env))
                .build();
    }
 

    @Bean
    public Job job(Step step1) {
        return jobBuilderFactory.get("job")
        		.incrementer(new RunIdIncrementer())
        		.start(step1)
                .build();
    }
}