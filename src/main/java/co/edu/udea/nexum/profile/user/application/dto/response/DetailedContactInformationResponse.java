package co.edu.udea.nexum.profile.user.application.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailedContactInformationResponse {
    private Long id;
    private String address;
    private String country;
    private String state;
    private String city;
    private String landline;
    private String mobile;
    private String email;
    private String academicEmail;
    private boolean whatsappAuthorization;
    private boolean current;
}
