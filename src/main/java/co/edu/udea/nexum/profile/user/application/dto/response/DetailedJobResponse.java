package co.edu.udea.nexum.profile.user.application.dto.response;

import co.edu.udea.nexum.profile.job.application.dto.response.JobAreaResponse;
import co.edu.udea.nexum.profile.job.application.dto.response.JobDelayResponse;
import co.edu.udea.nexum.profile.job.application.dto.response.JobInstitutionTypeResponse;
import co.edu.udea.nexum.profile.job.application.dto.response.JobSalaryRangeResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailedJobResponse {
    private Long id;
    private String companyName;
    private String country;
    private String position;
    private Boolean relatedToProgram;
    private JobSalaryRangeResponse salaryRange;
    private JobDelayResponse jobDelay;
    private JobAreaResponse jobArea;
    private JobInstitutionTypeResponse institutionType;
    private Boolean firstJob;
    private Boolean currentJob;
}
