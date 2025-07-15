package co.edu.udea.nexum.profile.job.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.job.domain.model.JobArea;
import co.edu.udea.nexum.profile.job.domain.spi.JobAreaPersistencePort;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.client.JobAreaFeign;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.mapper.response.JobAreaFeignResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobAreaFeignAdapter implements JobAreaPersistencePort {

    private final JobAreaFeign jobAreaFeign;
    private final JobAreaFeignResponseMapper jobAreaFeignResponseMapper;

    @Override
    public JobArea findById(Long id) {
        return jobAreaFeignResponseMapper.toDomain(
                jobAreaFeign.findById(id)
        );
    }
}
