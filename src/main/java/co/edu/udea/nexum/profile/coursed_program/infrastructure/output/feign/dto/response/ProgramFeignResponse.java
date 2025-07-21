package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.dto.response;

import co.edu.udea.nexum.profile.common.infrastructure.output.feign.dto.response.FeignResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgramFeignResponse implements FeignResponse {
    private Long id;
    private String name;
    private String code;
}
