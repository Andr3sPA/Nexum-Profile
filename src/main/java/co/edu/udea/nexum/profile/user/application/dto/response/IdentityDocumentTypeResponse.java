package co.edu.udea.nexum.profile.user.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdentityDocumentTypeResponse implements BaseResponse {
    private Long id;
    private String name;
    private String abbreviation;
}
