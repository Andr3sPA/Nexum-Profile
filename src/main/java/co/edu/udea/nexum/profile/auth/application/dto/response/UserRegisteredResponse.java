package co.edu.udea.nexum.profile.auth.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.IdentityDocumentTypeResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserRegisteredResponse implements BaseResponse {
    private UUID id;
    private String identityDocument;
    private IdentityDocumentTypeResponse identityDocumentType;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private LocalDate birthdate;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
