package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.client;

import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignBasicInterceptor;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignClientConfiguration;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignErrorDecoder;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.dto.response.ProgramVersionFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.COMMON_ID_PATH;
import static co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.utils.constants.CoursedProgramFeignConstants.PROGRAM_VERSION_FEIGN_NAME;
import static co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.utils.constants.CoursedProgramFeignConstants.PROGRAM_VERSION_FEIGN_URL;

@FeignClient(
        name = PROGRAM_VERSION_FEIGN_NAME,
        url = PROGRAM_VERSION_FEIGN_URL,
        configuration = {FeignClientConfiguration.class, FeignErrorDecoder.class, FeignBasicInterceptor.class}
)
public interface ProgramVersionFeign {
    @GetMapping(COMMON_ID_PATH)
    ProgramVersionFeignResponse findById(@PathVariable Long id);

    @GetMapping
    List<ProgramVersionFeignResponse> findAll();
}
