package co.edu.udea.nexum.profile.user.application.dto.response.detailed;

import co.edu.udea.nexum.profile.family_information.domain.utils.enums.MaritalState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailedFamilyInformationResponse {
    private Long id;
    private MaritalState maritalState;
    private Short childNumber;
}
