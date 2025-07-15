package co.edu.udea.nexum.profile.job.infrastructure.output.feign.client;

import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignBasicInterceptor;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignClientConfiguration;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignErrorDecoder;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.dto.response.SalaryRangeFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.COMMON_ID_PATH;
import static co.edu.udea.nexum.profile.job.infrastructure.output.feign.utils.constants.JobFeignConstants.SALARY_RANGE_FEIGN_NAME;
import static co.edu.udea.nexum.profile.job.infrastructure.output.feign.utils.constants.JobFeignConstants.SALARY_RANGE_FEIGN_URL;

@FeignClient(
        name = SALARY_RANGE_FEIGN_NAME,
        url = SALARY_RANGE_FEIGN_URL,
        configuration = {FeignClientConfiguration.class, FeignErrorDecoder.class, FeignBasicInterceptor.class}
)
public interface SalaryRangeFeign {
    @GetMapping(COMMON_ID_PATH)
    SalaryRangeFeignResponse findById(@PathVariable Long id);
}
