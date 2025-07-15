package co.edu.udea.nexum.profile.auth.application.dto.response;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AuthenticatedUserResponse implements BaseResponse {
    private UUID id;
    private RoleName role;
    private String email;
    private String token;
}
