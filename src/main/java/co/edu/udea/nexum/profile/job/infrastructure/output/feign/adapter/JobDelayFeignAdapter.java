package co.edu.udea.nexum.profile.job.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.job.domain.model.JobDelay;
import co.edu.udea.nexum.profile.job.domain.spi.JobDelayPersistencePort;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.client.JobDelayFeign;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.mapper.response.JobDelayFeignResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobDelayFeignAdapter implements JobDelayPersistencePort {

    private final JobDelayFeign jobDelayFeign;
    private final JobDelayFeignResponseMapper jobDelayFeignResponseMapper;

    @Override
    public JobDelay findById(Long id) {
        return jobDelayFeignResponseMapper.toDomain(
                jobDelayFeign.findById(id)
        );
    }
}
