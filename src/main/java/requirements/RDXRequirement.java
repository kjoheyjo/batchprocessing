package requirements;

import java.util.Date;

public class RDXRequirement {

    private Long HIRING_FOR_ID;
    private Integer COMP_ID;
    private Integer RDX_USER_ID;
    private String HIRING_FOR;
    private Date TIMESTAMP;
    private Date MODIFIED_TIMESTAMP;
    private String STATUS;
    private Date CLOSE_TIMESTAMP;

    public Long getHIRING_FOR_ID() {
        return HIRING_FOR_ID;
    }

    public void setHIRING_FOR_ID(Long HIRING_FOR_ID) {
        this.HIRING_FOR_ID = HIRING_FOR_ID;
    }

    public Integer getCOMP_ID() {
        return COMP_ID;
    }

    public void setCOMP_ID(Integer COMP_ID) {
        this.COMP_ID = COMP_ID;
    }

    public Integer getRDX_USER_ID() {
        return RDX_USER_ID;
    }

    public void setRDX_USER_ID(Integer RDX_USER_ID) {
        this.RDX_USER_ID = RDX_USER_ID;
    }

    public String getHIRING_FOR() {
        return HIRING_FOR;
    }

    public void setHIRING_FOR(String HIRING_FOR) {
        this.HIRING_FOR = HIRING_FOR;
    }

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public Date getMODIFIED_TIMESTAMP() {
        return MODIFIED_TIMESTAMP;
    }

    public void setMODIFIED_TIMESTAMP(Date MODIFIED_TIMESTAMP) {
        this.MODIFIED_TIMESTAMP = MODIFIED_TIMESTAMP;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public Date getCLOSE_TIMESTAMP() {
        return CLOSE_TIMESTAMP;
    }

    public void setCLOSE_TIMESTAMP(Date CLOSE_TIMESTAMP) {
        this.CLOSE_TIMESTAMP = CLOSE_TIMESTAMP;
    }

    @Override
    public String toString() {
        return "RDXRequirement{" +
                "HIRING_FOR_ID=" + HIRING_FOR_ID +
                ", COMP_ID=" + COMP_ID +
                ", RDX_USER_ID=" + RDX_USER_ID +
                ", HIRING_FOR='" + HIRING_FOR + '\'' +
                ", TIMESTAMP=" + TIMESTAMP +
                ", MODIFIED_TIMESTAMP=" + MODIFIED_TIMESTAMP +
                ", STATUS='" + STATUS + '\'' +
                ", CLOSE_TIMESTAMP='" + CLOSE_TIMESTAMP + '\'' +
                '}';
    }
}
