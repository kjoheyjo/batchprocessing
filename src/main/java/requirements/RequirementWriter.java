package requirements;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RequirementWriter implements ItemWriter<RequirementDTO> {

   

    @Autowired
    public DataSource dataSource;

    public Connection conn;

    public void write(List<?extends RequirementDTO> requirementDTO) {
    	
    	for(RequirementDTO obj:requirementDTO) {
     System.out.println(obj);
     updateLastWriteId(obj);
    	}
    }

    private void updateLastWriteId(RequirementDTO obj) {
        try {
            if(null == conn) {
                conn = dataSource.getConnection();
            }
            String sql = "update requirementMigrationStatus set requirementId = ? where clientId=? and type=1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Integer.valueOf(obj.getRequirementId()));
            stmt.setInt(2,obj.getClientId());
            stmt.executeUpdate();
           
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
