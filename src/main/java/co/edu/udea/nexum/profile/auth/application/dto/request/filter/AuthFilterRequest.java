package co.edu.udea.nexum.profile.auth.application.dto.request.filter;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthFilterRequest implements BaseRequest {
    private String email;
    private RoleName role;
}
