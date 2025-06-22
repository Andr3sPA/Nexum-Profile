package co.edu.udea.nexum.profile.coursed_program.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoursedProgramResponse implements BaseResponse {
    private Long id;
    private CoursedProgramUserResponse user;
    private Long programVersionId;
    private Integer graduationYear;
}
