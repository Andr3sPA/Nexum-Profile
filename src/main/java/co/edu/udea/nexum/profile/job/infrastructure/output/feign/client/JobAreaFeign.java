package co.edu.udea.nexum.profile.job.infrastructure.output.feign.client;

import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignBasicInterceptor;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignClientConfiguration;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignErrorDecoder;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.dto.response.JobAreaFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.COMMON_ID_PATH;
import static co.edu.udea.nexum.profile.job.infrastructure.output.feign.utils.constants.JobFeignConstants.JOB_AREA_FEIGN_NAME;
import static co.edu.udea.nexum.profile.job.infrastructure.output.feign.utils.constants.JobFeignConstants.JOB_AREA_FEIGN_URL;

@FeignClient(
        name = JOB_AREA_FEIGN_NAME,
        url = JOB_AREA_FEIGN_URL,
        configuration = {FeignClientConfiguration.class, FeignErrorDecoder.class, FeignBasicInterceptor.class}
)
public interface JobAreaFeign {
    @GetMapping(COMMON_ID_PATH)
    JobAreaFeignResponse findById(@PathVariable Long id);
}
