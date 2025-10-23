package co.edu.udea.nexum.profile.auth.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import static co.edu.udea.nexum.profile.auth.application.utils.constants.AuthAppConstants.*;
import static co.edu.udea.nexum.profile.user.application.utils.constants.UserAppConstants.*;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.EMAIL_REGEX;

@Data
@Builder
public class EmployerRegisterRequest implements BaseRequest {
    @NotBlank(message = NAME_FIELD_NOT_NULL_MESSAGE)
    private String name;

    @Pattern(regexp = EMAIL_REGEX, message = AUTH_EMAIL_FIELD_INVALID_FORMAT_MESSAGE)
    @NotBlank(message = AUTH_EMAIL_FIELD_NOT_NULL_MESSAGE)
    private String email;

    @NotBlank(message = AUTH_PASSWORD_FIELD_NOT_NULL_MESSAGE)
    private String password;

    // Optional: company tax id (NIT). If provided, it will be used as identity document.
    private String nit;

    // Optional edit code used to link existing resources to the created employer
    private String editCode;
}