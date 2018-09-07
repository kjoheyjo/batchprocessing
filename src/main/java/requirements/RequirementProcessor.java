package requirements;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;

public class RequirementProcessor implements ItemProcessor<RMSRequirement, RequirementDTO> {

    private static final String STATUS_OPEN = "open";
    private static final String STATUS_CLOSED = "close";
    private static final Integer STATUS_OPEN_RMS = 1;
    private static final Integer STATUS_CLOSED_RMS = 4;
    private static final Integer SOURCE_RMJ = 1;

    /*public RequirementDTO process(final RDXRequirement rdxRequirement) throws Exception {
        return getRequirementRDXProjectMapping(rdxRequirement);
    }

    private RequirementDTO getRequirementRDXProjectMapping(RDXRequirement rdxRequirement) {
        RequirementDTO requirementDTO = new RequirementDTO();

        requirementDTO.setId(rdxRequirement.getCOMP_ID() + "_" + rdxRequirement.getRDX_USER_ID() + "_" +
                rdxRequirement.getHIRING_FOR_ID());
        requirementDTO.setCreatedBy(rdxRequirement.getRDX_USER_ID());
        requirementDTO.setProjectName(rdxRequirement.getHIRING_FOR());
        requirementDTO.setCreatedOn(rdxRequirement.getTIMESTAMP());
        if(STATUS_CLOSED == rdxRequirement.getSTATUS()) {
            requirementDTO.setUpdatedOn(rdxRequirement.getCLOSE_TIMESTAMP());
            requirementDTO.setStatus(STATUS_CLOSED_RMS);
        } else {
            requirementDTO.setUpdatedOn(rdxRequirement.getMODIFIED_TIMESTAMP());
            requirementDTO.setStatus(STATUS_OPEN_RMS);
        }
        requirementDTO.setSource(SOURCE_RMJ);
        requirementDTO.setClientId(rdxRequirement.getCOMP_ID());
        requirementDTO.setRequirementId(rdxRequirement.getHIRING_FOR_ID());

        return requirementDTO;
    }*/

    public RequirementDTO process(final RMSRequirement rmsRequirement) throws Exception {
        return getRequirementRMSProjectMapping(rmsRequirement);
    }

    private RequirementDTO getRequirementRMSProjectMapping(RMSRequirement rmsRequirement) {
        System.out.println(rmsRequirement.toString());
        rmsRequirement.setId(rmsRequirement.getProjectId()+"");
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<RMSRequirement, RequirementDTO> typeMap = modelMapper.createTypeMap(RMSRequirement.class,
                RequirementDTO.class, "requirementMap");
        typeMap.addMapping(RMSRequirement::getTitle, RequirementDTO::setJobTitle);
        typeMap.addMapping(RMSRequirement::getId, RequirementDTO::setRequirementId);
        RequirementDTO requirementDTO = modelMapper.map(rmsRequirement, RequirementDTO.class, typeMap.getName());
        return requirementDTO;
    }
    
    

}
