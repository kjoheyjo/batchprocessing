package requirements;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class RMSRequirement {

    @NotNull
    @PositiveOrZero
    private Integer clientId;

    private Long projectId;

    @NotNull
    @NotEmpty
    @Size( min = 1, max = 200 , message = "Requirement tittle must be between 1 and 200 characters")
    private String title;

    private Integer employerId;
    private String projectName;
    private String projectNameMD5;
    private String description;
    private Integer minSalary;
    private Integer maxSalary;
    private String salaryCurrency;
    private String otherSalary;
    private Integer minExp;
    private Integer maxExp;
    private List<String> Keywords;
    private List<String> cityIds;
    private List<String> internationalLocations;
    private List<String> otherLocations;
    private Integer industry;
    private String functionalArea;
    private String role;
    private Integer hiringFor;
    private String referenceNo;
    private Integer vacancies;
    private String ugcourseIds;
    private Integer ugSelection;
    private String pgcourseIds;
    private Boolean pgSelection;
    private String ppgcourseIds;
    private Boolean ppgSelection;
    private String ugspecIds;
    private String pgspecIds;
    private String ppgspecIds;

    private Boolean ugpgRelation;
    private Boolean pgppgRelation;
    private Boolean filterFlag;
    private Integer status;
    private Integer source;
    private Long prefillProjectId;
    private Date createdOn;
    private Integer createdBy;
    private Date updatedOn;
    private Integer updatedBy;

    private String companyName;
    private Integer visibilityStatus;
    private Integer  blockDuration;
    private Integer billingDetail;
    private Boolean showbillingDetail;
    private Integer billingDetailId;
    private Integer hiringManagerId;
    private Integer requestId;
    private Date lastActiveDate;

    private String aboutCompany;

    private String id;

    public Integer getClientId() {
        return clientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNameMD5() {
        return projectNameMD5;
    }

    public void setProjectNameMD5(String projectNameMD5) {
        this.projectNameMD5 = projectNameMD5;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getSalaryCurrency() {
        return salaryCurrency;
    }

    public void setSalaryCurrency(String salaryCurrency) {
        this.salaryCurrency = salaryCurrency;
    }

    public String getOtherSalary() {
        return otherSalary;
    }

    public void setOtherSalary(String otherSalary) {
        this.otherSalary = otherSalary;
    }

    public Integer getMinExp() {
        return minExp;
    }

    public void setMinExp(Integer minExp) {
        this.minExp = minExp;
    }

    public Integer getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(Integer maxExp) {
        this.maxExp = maxExp;
    }

    public List<String> getKeywords() {
        return Keywords;
    }

    public void setKeywords(List<String> keywords) {
        Keywords = keywords;
    }

    public List<String> getCityIds() {
        return cityIds;
    }

    public void setCityIds(List<String> cityIds) {
        this.cityIds = cityIds;
    }

    public List<String> getInternationalLocations() {
        return internationalLocations;
    }

    public void setInternationalLocations(List<String> internationalLocations) {
        this.internationalLocations = internationalLocations;
    }

    public List<String> getOtherLocations() {
        return otherLocations;
    }

    public void setOtherLocations(List<String> otherLocations) {
        this.otherLocations = otherLocations;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public String getFunctionalArea() {
        return functionalArea;
    }

    public void setFunctionalArea(String functionalArea) {
        this.functionalArea = functionalArea;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getHiringFor() {
        return hiringFor;
    }

    public void setHiringFor(Integer hiringFor) {
        this.hiringFor = hiringFor;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    public String getUgcourseIds() {
        return ugcourseIds;
    }

    public void setUgcourseIds(String ugcourseIds) {
        this.ugcourseIds = ugcourseIds;
    }

    public Integer getUgSelection() {
        return ugSelection;
    }

    public void setUgSelection(Integer ugSelection) {
        this.ugSelection = ugSelection;
    }

    public String getPgcourseIds() {
        return pgcourseIds;
    }

    public void setPgcourseIds(String pgcourseIds) {
        this.pgcourseIds = pgcourseIds;
    }

    public Boolean getPgSelection() {
        return pgSelection;
    }

    public void setPgSelection(Boolean pgSelection) {
        this.pgSelection = pgSelection;
    }

    public String getPpgcourseIds() {
        return ppgcourseIds;
    }

    public void setPpgcourseIds(String ppgcourseIds) {
        this.ppgcourseIds = ppgcourseIds;
    }

    public Boolean getPpgSelection() {
        return ppgSelection;
    }

    public void setPpgSelection(Boolean ppgSelection) {
        this.ppgSelection = ppgSelection;
    }

    public String getUgspecIds() {
        return ugspecIds;
    }

    public void setUgspecIds(String ugspecIds) {
        this.ugspecIds = ugspecIds;
    }

    public String getPgspecIds() {
        return pgspecIds;
    }

    public void setPgspecIds(String pgspecIds) {
        this.pgspecIds = pgspecIds;
    }

    public String getPpgspecIds() {
        return ppgspecIds;
    }

    public void setPpgspecIds(String ppgspecIds) {
        this.ppgspecIds = ppgspecIds;
    }

    public Boolean getUgpgRelation() {
        return ugpgRelation;
    }

    public void setUgpgRelation(Boolean ugpgRelation) {
        this.ugpgRelation = ugpgRelation;
    }

    public Boolean getPgppgRelation() {
        return pgppgRelation;
    }

    public void setPgppgRelation(Boolean pgppgRelation) {
        this.pgppgRelation = pgppgRelation;
    }

    public Boolean getFilterFlag() {
        return filterFlag;
    }

    public void setFilterFlag(Boolean filterFlag) {
        this.filterFlag = filterFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Long getPrefillProjectId() {
        return prefillProjectId;
    }

    public void setPrefillProjectId(Long prefillProjectId) {
        this.prefillProjectId = prefillProjectId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getVisibilityStatus() {
        return visibilityStatus;
    }

    public void setVisibilityStatus(Integer visibilityStatus) {
        this.visibilityStatus = visibilityStatus;
    }

    public Integer getBlockDuration() {
        return blockDuration;
    }

    public void setBlockDuration(Integer blockDuration) {
        this.blockDuration = blockDuration;
    }

    public Integer getBillingDetail() {
        return billingDetail;
    }

    public void setBillingDetail(Integer billingDetail) {
        this.billingDetail = billingDetail;
    }

    public Boolean getShowbillingDetail() {
        return showbillingDetail;
    }

    public void setShowbillingDetail(Boolean showbillingDetail) {
        this.showbillingDetail = showbillingDetail;
    }

    public Integer getBillingDetailId() {
        return billingDetailId;
    }

    public void setBillingDetailId(Integer billingDetailId) {
        this.billingDetailId = billingDetailId;
    }

    public Integer getHiringManagerId() {
        return hiringManagerId;
    }

    public void setHiringManagerId(Integer hiringManagerId) {
        this.hiringManagerId = hiringManagerId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Date getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(Date lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }

    public String getAboutCompany() {
        return aboutCompany;
    }

    public void setAboutCompany(String aboutCompany) {
        this.aboutCompany = aboutCompany;
    }

    @Override
    public String toString() {
        return "RMSRequirement{" +
                "clientId=" + clientId +
                ", projectId=" + projectId +
                ", title='" + title + '\'' +
                ", employerId=" + employerId +
                ", projectName='" + projectName + '\'' +
                ", projectNameMD5='" + projectNameMD5 + '\'' +
                ", description='" + description + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", salaryCurrency='" + salaryCurrency + '\'' +
                ", otherSalary='" + otherSalary + '\'' +
                ", minExp=" + minExp +
                ", maxExp=" + maxExp +
                ", Keywords=" + Keywords +
                ", cityIds=" + cityIds +
                ", internationalLocations=" + internationalLocations +
                ", otherLocations=" + otherLocations +
                ", industry=" + industry +
                ", functionalArea='" + functionalArea + '\'' +
                ", role='" + role + '\'' +
                ", hiringFor=" + hiringFor +
                ", referenceNo='" + referenceNo + '\'' +
                ", vacancies=" + vacancies +
                ", ugcourseIds='" + ugcourseIds + '\'' +
                ", ugSelection=" + ugSelection +
                ", pgcourseIds='" + pgcourseIds + '\'' +
                ", pgSelection=" + pgSelection +
                ", ppgcourseIds='" + ppgcourseIds + '\'' +
                ", ppgSelection=" + ppgSelection +
                ", ugspecIds='" + ugspecIds + '\'' +
                ", pgspecIds='" + pgspecIds + '\'' +
                ", ppgspecIds='" + ppgspecIds + '\'' +
                ", ugpgRelation=" + ugpgRelation +
                ", pgppgRelation=" + pgppgRelation +
                ", filterFlag=" + filterFlag +
                ", status=" + status +
                ", source=" + source +
                ", prefillProjectId=" + prefillProjectId +
                ", createdOn=" + createdOn +
                ", createdBy=" + createdBy +
                ", updatedOn=" + updatedOn +
                ", updatedBy=" + updatedBy +
                ", companyName='" + companyName + '\'' +
                ", visibilityStatus=" + visibilityStatus +
                ", blockDuration=" + blockDuration +
                ", billingDetail=" + billingDetail +
                ", showbillingDetail=" + showbillingDetail +
                ", billingDetailId=" + billingDetailId +
                ", hiringManagerId=" + hiringManagerId +
                ", requestId=" + requestId +
                ", lastActiveDate=" + lastActiveDate +
                ", aboutCompany='" + aboutCompany + '\'' +
                '}';
    }
}
