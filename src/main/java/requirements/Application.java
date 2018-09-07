package requirements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	
	
	@Autowired
    JobLauncher jobLauncher;
	
	 @Autowired
	    public DataSource dataSource;

	    public Connection conn;
	
	
    public static void main(String args[]) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    Job job;
    
    @Override
    public void run(String... args) throws Exception
    {
    	Runnable runnable = () -> {
    	    try {
    	    	List<String> clientIds= new ArrayList<>();
    	    	try {
    	            if(null == conn) {
    	                conn = dataSource.getConnection();
    	            }
    	            String sql = "select clientId from ShardSelector s1 join ShardDetail s2 on s1.shardId=s2.shardId";
    	            PreparedStatement stmt = conn.prepareStatement(sql);
    	           
    	            ResultSet rs=stmt.executeQuery();
    	            
    	            
    	            while(rs.next())
    	            {
    	            	clientIds.add(rs.getString("clientId"));
    	            }
    	            rs.close();
    	            stmt.close();
    	        } catch(SQLException e) {
    	            System.out.println(e.getMessage());
    	            System.exit(1);
    	        }
    	    	
    	    	String insertSql="INSERT IGNORE INTO `requirementMigrationStatus`(`type`,`clientId`,`recruiterId`,`requirementId`,`status`)VALUES(?,?,?,?,?)";
    	    	
    	    	PreparedStatement stmt = conn.prepareStatement(insertSql);
	            
    	    	
	    		int index =1;
    	    	for(String clientStr:clientIds)
			{
    	    		if(index%100==0)
    	    		{
    	    			if(index>1)
    	    			{
    	    				stmt.executeBatch();
    	    				stmt.close();
    	    				stmt=null;
    	    			}
    	    			stmt = conn.prepareStatement(insertSql);
    	    		}
    	    		index++;
    	    		stmt.setInt(1,1);
    	            stmt.setInt(2,Integer.valueOf(clientStr));
    	          
    	            stmt.setInt(3,0);
    	            stmt.setInt(4,1);
    	          
    	            stmt.setInt(5,0);  
    	           
    	            stmt.addBatch();
					}
    	    	
    	    	try {
					stmt.executeBatch();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    	stmt.close();
    	    	//conn.close();
	    	
    	    	while(true) {
    	    
    	    	System.out.println("job started");
		    	   JobParameters params = new JobParametersBuilder()
		                    .addString("id", System.currentTimeMillis()+"")
		                    .toJobParameters();
		       JobExecution obj= jobLauncher.run(job, params);
		       obj.stop();
		        
		        System.out.println("job ended...............................................................................");
		   
		        Thread.sleep(100);
    	    	}
		
    	    }
    	    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	};

    	Thread thread = new Thread(runnable);
    	thread.start();
    	 
               
    }

}
