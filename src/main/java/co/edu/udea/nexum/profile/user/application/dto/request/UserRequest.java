package co.edu.udea.nexum.profile.user.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import co.edu.udea.nexum.profile.common.application.utils.constraints.AllowedValues;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

import static co.edu.udea.nexum.profile.auth.application.utils.constants.AuthAppConstants.AUTH_EMAIL_FIELD_INVALID_FORMAT_MESSAGE;
import static co.edu.udea.nexum.profile.user.application.utils.constants.UserAppConstants.*;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.*;

@Data
@Builder
public class UserRequest implements BaseRequest {
    @Pattern(regexp = IDENTITY_DOCUMENT_REGEX, message = DOCUMENT_FIELD_INVALID_FORMAT_MESSAGE)
    @NotNull(message = DOCUMENT_FIELD_NOT_NULL_MESSAGE)
    private String identityDocument;

    @NotNull(message = DOCUMENT_TYPE_FIELD_NOT_NULL_MESSAGE)
    @Positive(message = DOCUMENT_TYPE_MUST_BE_POSITIVE_MESSAGE)
    private Long idIdentityDocumentType;

    @NotBlank(message = NAME_FIELD_NOT_NULL_MESSAGE)
    private String name;

    private String middleName;

    @NotBlank(message = LASTNAME_FIELD_NOT_NULL_MESSAGE)
    private String lastname;

    @NotBlank(message = SECOND_LASTNAME_FIELD_NOT_NULL_MESSAGE)
    private String secondLastname;

    @NotBlank(message = GENDER_FIELD_NOT_NULL_MESSAGE)
    @AllowedValues( values = {MALE_NAME, FEMALE_NAME, NON_BINARY_NAME, OTHER_NAME}, message = GENDER_OUT_OF_RANGE_MESSAGE)
    private String gender;

    @Pattern(regexp = INSTITUTIONAL_EMAIL_REGEX, message = INSTITUTIONAL_EMAIL_FIELD_INVALID_FORMAT_MESSAGE)
    private String institutionalEmail;

    @NotNull(message = BIRTHDATE_FIELD_NOT_NULL_MESSAGE)
    @Past(message = BIRTHDATE_MUST_BE_PAST_MESSAGE)
    private LocalDate birthdate;
}
