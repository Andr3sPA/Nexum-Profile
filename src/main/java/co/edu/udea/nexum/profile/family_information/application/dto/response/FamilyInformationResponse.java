package co.edu.udea.nexum.profile.family_information.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import co.edu.udea.nexum.profile.family_information.domain.utils.enums.MaritalState;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FamilyInformationResponse implements BaseResponse {
    private Long id;
    private FamilyInformationUserResponse user;
    private MaritalState maritalState;
    private Short childNumber;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}