package co.edu.udea.nexum.profile.user.infrastructure.output.feign.dto.response;

import co.edu.udea.nexum.profile.common.infrastructure.output.feign.dto.response.FeignResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdentityDocumentTypeFeignResponse implements FeignResponse {
    private Long id;
    private String name;
    private String abbreviation;
}
