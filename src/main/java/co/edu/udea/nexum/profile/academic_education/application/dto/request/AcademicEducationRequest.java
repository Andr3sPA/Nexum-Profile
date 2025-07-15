package co.edu.udea.nexum.profile.academic_education.application.dto.request;

import co.edu.udea.nexum.profile.academic_education.domain.utils.enums.StudyType;
import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static co.edu.udea.nexum.profile.academic_education.application.utils.constants.AcademicEducationAppConstants.*;

@Data
@Builder
public class AcademicEducationRequest implements BaseRequest {

    @NotNull(message = USER_ID_FIELD_NOT_NULL_MESSAGE)
    private UUID userId;

    @NotNull(message = STUDY_TYPE_FIELD_NOT_NULL_MESSAGE)
    private StudyType type;

    @NotBlank(message = STUDY_NAME_FIELD_NOT_BLANK_MESSAGE)
    private String studyName;

    @NotBlank(message = INSTITUTION_FIELD_NOT_BLANK_MESSAGE)
    private String institution;

    @NotBlank(message = COUNTRY_FIELD_NOT_BLANK_MESSAGE)
    private String country;
}
