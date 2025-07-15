package co.edu.udea.nexum.profile.job.infrastructure.output.feign.dto.response;

import co.edu.udea.nexum.profile.common.infrastructure.output.feign.dto.response.FeignResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDelayFeignResponse implements FeignResponse {
    private Long id;
    private String label;
    private Integer order;
    private Boolean active;
}
