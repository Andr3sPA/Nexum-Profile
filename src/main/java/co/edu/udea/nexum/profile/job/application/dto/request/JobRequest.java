package co.edu.udea.nexum.profile.job.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static co.edu.udea.nexum.profile.job.application.utils.constants.JobAppConstants.*;

@Data
@Builder
public class JobRequest implements BaseRequest {
    @NotNull(message = USER_ID_NOT_NULL_MESSAGE)
    private UUID userId;

    @NotBlank(message = COMPANY_NAME_NOT_BLANK_MESSAGE)
    private String companyName;

    @NotBlank(message = COUNTRY_NOT_BLANK_MESSAGE)
    private String country;

    @NotBlank(message = POSITION_NOT_BLANK_MESSAGE)
    private String position;

    @NotNull(message = RELATED_TO_PROGRAM_NOT_NULL_MESSAGE)
    private Boolean relatedToProgram;

    @NotNull(message = SALARY_NOT_NULL_MESSAGE)
    private Long salaryRangeId;

    @NotNull(message = JOB_DELAY_NOT_NULL_MESSAGE)
    private Long jobDelayId;

    @NotNull(message = JOB_AREA_NOT_NULL_MESSAGE)
    private Long jobAreaId;

    @NotNull(message = JOB_INSTITUTION_TYPE_NOT_NULL_MESSAGE)
    private Long institutionTypeId;

    @NotNull(message = FIRST_JOB_NOT_NULL_MESSAGE)
    private Boolean firstJob;

    @NotNull(message = CURRENT_JOB_NOT_NULL_MESSAGE)
    private Boolean currentJob;
}
