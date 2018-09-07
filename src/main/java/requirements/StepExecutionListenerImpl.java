package requirements;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class StepExecutionListenerImpl implements StepExecutionListener{
 
	
	
	
	
	 @Autowired
	    private Environment env;
	public StepExecutionListenerImpl(Environment env) {
		super();
		this.env = env;
	}

	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		HikariConfig config = new HikariConfig();
	    HikariDataSource ds = null;
		try{
			config.setJdbcUrl(env.getProperty("spring.datasource.url"));
	        config.setUsername(env.getProperty("spring.datasource.username"));
	        config.setPassword(env.getProperty("spring.datasource.password"));
	        config.setMaximumPoolSize(1);
	        ds = new HikariDataSource( config );
			System.out.println("hey........");
			System.out.println("hey........");
			System.out.println("hey........");
			System.out.println("hey........");
			System.out.println("hey........");
			System.out.println("hey........");
			System.out.println("hey........");

			System.out.println("hey........");
			System.out.println("hey........");
		
			String sql1="update requirementMigrationStatus set status=2 where status=1 and type=1";
    	
    	java.sql.Connection conn = ds.getConnection();
            Statement stmt=conn.createStatement();   
            // Executing SQL query  
            stmt.executeUpdate(sql1); 
        stmt.close();
        conn.close();
        ds.close();
        
        
		
		}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
	
		
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		
	}
}