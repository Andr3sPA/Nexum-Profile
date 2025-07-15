package co.edu.udea.nexum.profile.academic_education.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcademicEducationResponse implements BaseResponse {
    private Long id;
    private AcademicEducationUserResponse user;
    private String type;
    private String studyName;
    private String institution;
    private String country;
}
