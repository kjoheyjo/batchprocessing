package requirements;

import org.apache.ibatis.jdbc.Null;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RequirementRowMapper implements RowMapper<RMSRequirement> {

    /*public RDXRequirement mapRow(ResultSet rs, int rowNum) throws SQLException {
        RDXRequirement RDXRequirement = new RDXRequirement();
        RDXRequirement.setCOMP_ID(rs.getInt("COMP_ID"));
        RDXRequirement.setHIRING_FOR_ID(rs.getLong("HIRING_FOR_ID"));
        RDXRequirement.setRDX_USER_ID(rs.getInt("RDX_USER_ID"));
        RDXRequirement.setHIRING_FOR(rs.getString("HIRING_FOR"));
        RDXRequirement.setTIMESTAMP(rs.getDate("TIMESTAMP"));
        RDXRequirement.setSTATUS(rs.getString("STATUS"));
        RDXRequirement.setMODIFIED_TIMESTAMP(rs.getDate("MODIFIED_TIMESTAMP"));
        RDXRequirement.setCLOSE_TIMESTAMP(rs.getString("CLOSE_TIMESTAMP"));
        return RDXRequirement;
    }*/

    public RMSRequirement mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }

}
