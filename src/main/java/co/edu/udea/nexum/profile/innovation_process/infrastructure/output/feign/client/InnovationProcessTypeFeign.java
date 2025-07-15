package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.client;

import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignBasicInterceptor;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignClientConfiguration;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignErrorDecoder;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.dto.response.InnovationProcessTypeFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.COMMON_ID_PATH;
import static co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.utils.constants.GraduateParticipationFeignConstants.*;

@FeignClient(
        name = INNOVATION_PROCESS_TYPE_FEIGN_NAME,
        url = INNOVATION_PROCESS_TYPE_FEIGN_URL,
        configuration = {
                FeignClientConfiguration.class,
                FeignErrorDecoder.class,
                FeignBasicInterceptor.class
        }
)
public interface InnovationProcessTypeFeign {
    @GetMapping(COMMON_ID_PATH)
    InnovationProcessTypeFeignResponse findById(@PathVariable Long id);

    @PostMapping(IDS_PATH)
    List<InnovationProcessTypeFeignResponse> findByIds(@RequestParam List<Long> ids);
}
