package co.edu.udea.nexum.profile.user.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserResponse implements BaseResponse {
    private UUID id;
    private String identityDocument;
    private IdentityDocumentTypeResponse identityDocumentType;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private Gender gender;
    private LocalDate birthdate;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
