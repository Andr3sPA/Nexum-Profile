package co.edu.udea.nexum.profile.user.infrastructure.output.feign.client;

import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignBasicInterceptor;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignClientConfiguration;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.feign.FeignErrorDecoder;
import co.edu.udea.nexum.profile.user.infrastructure.output.feign.dto.response.IdentityDocumentTypeFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.COMMON_ID_PATH;
import static co.edu.udea.nexum.profile.user.infrastructure.output.feign.utils.constants.UserFeignConstants.IDENTIFICATION_TYPE_FEIGN_NAME;
import static co.edu.udea.nexum.profile.user.infrastructure.output.feign.utils.constants.UserFeignConstants.IDENTIFICATION_TYPE_FEIGN_URL;

@FeignClient(
        name = IDENTIFICATION_TYPE_FEIGN_NAME,
        url = IDENTIFICATION_TYPE_FEIGN_URL,
        configuration = {
                FeignClientConfiguration.class,
                FeignErrorDecoder.class,
                FeignBasicInterceptor.class
        }
)
public interface IdentityDocumentTypeFeign {

    @GetMapping(COMMON_ID_PATH)
    IdentityDocumentTypeFeignResponse getIdentityTypeById(@PathVariable Long id);
}
