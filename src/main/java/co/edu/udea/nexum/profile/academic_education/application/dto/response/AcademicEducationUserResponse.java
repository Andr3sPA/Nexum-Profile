package co.edu.udea.nexum.profile.academic_education.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AcademicEducationUserResponse implements BaseResponse {
    private UUID id;
    private String name;
    private String lastname;
}
