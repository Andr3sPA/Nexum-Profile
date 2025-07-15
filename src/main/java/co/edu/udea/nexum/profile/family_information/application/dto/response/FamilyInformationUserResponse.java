package co.edu.udea.nexum.profile.family_information.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class FamilyInformationUserResponse implements BaseResponse {
    private UUID id;
    private String name;
    private String lastname;
}
