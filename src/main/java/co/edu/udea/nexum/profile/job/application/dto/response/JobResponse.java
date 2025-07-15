package co.edu.udea.nexum.profile.job.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class JobResponse implements BaseResponse {
    private Long id;
    private JobUserResponse user;
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
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
