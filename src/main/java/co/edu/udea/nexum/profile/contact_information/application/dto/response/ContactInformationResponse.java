package co.edu.udea.nexum.profile.contact_information.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ContactInformationResponse implements BaseResponse {
    private Long id;
    private ContactInformationUserResponse user;
    private String address;
    private String country;
    private String state;
    private String city;
    private String landline;
    private String mobile;
    private String email;
    private String academicEmail;
    private Boolean whatsappAuthorization;
    private Boolean current;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
