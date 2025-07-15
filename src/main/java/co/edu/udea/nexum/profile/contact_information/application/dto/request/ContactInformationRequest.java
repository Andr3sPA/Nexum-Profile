package co.edu.udea.nexum.profile.contact_information.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static co.edu.udea.nexum.profile.contact_information.application.utils.constants.ContactInformationAppConstants.*;
import static co.edu.udea.nexum.profile.coursed_program.application.utils.constants.CoursedProgramConstants.USER_ID_FIELD_NOT_NULL_MESSAGE;

@Data
@Builder
public class ContactInformationRequest implements BaseRequest {

    @NotNull(message = USER_ID_FIELD_NOT_NULL_MESSAGE)
    private UUID userId;

    @NotBlank(message = ADDRESS_FIELD_NOT_BLANK_MESSAGE)
    private String address;

    @NotBlank(message = COUNTRY_FIELD_NOT_BLANK_MESSAGE)
    private String country;

    @NotBlank(message = STATE_FIELD_NOT_BLANK_MESSAGE)
    private String state;

    @NotBlank(message = CITY_FIELD_NOT_BLANK_MESSAGE)
    private String city;

    @NotBlank(message = LANDLINE_FIELD_NOT_BLANK_MESSAGE)
    private String landline;

    @NotBlank(message = CELLPHONE_FIELD_NOT_BLANK_MESSAGE)
    private String mobile;

    @Email(message = EMAIL_FIELD_INVALID_MESSAGE)
    @NotBlank(message = EMAIL_FIELD_NOT_BLANK_MESSAGE)
    private String email;

    @Email(message = ACADEMIC_EMAIL_FIELD_INVALID_MESSAGE)
    private String academicEmail;

    @NotNull(message = WHATSAPP_AUTHORIZATION_FIELD_NOT_NULL_MESSAGE)
    private Boolean whatsappAuthorization;

    @NotNull(message = IS_CURRENT_FIELD_NOT_NULL_MESSAGE)
    private Boolean current;
}
