package co.edu.udea.nexum.profile.auth.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import static co.edu.udea.nexum.profile.auth.application.utils.constants.AuthAppConstants.*;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.EMAIL_REGEX;

@Data
@Builder
public class AuthenticationRequest implements BaseRequest {
    @Pattern(regexp = EMAIL_REGEX, message = AUTH_EMAIL_FIELD_INVALID_FORMAT_MESSAGE)
    @NotNull(message = AUTH_EMAIL_FIELD_NOT_NULL_MESSAGE)
    private String email;

    @NotNull(message = AUTH_PASSWORD_FIELD_NOT_NULL_MESSAGE)
    private String password;
}
