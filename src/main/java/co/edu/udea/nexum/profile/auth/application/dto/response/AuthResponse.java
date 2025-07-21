package co.edu.udea.nexum.profile.auth.application.dto.response;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse implements BaseResponse {
    private String id;
    private String email;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private RoleName role;
}
