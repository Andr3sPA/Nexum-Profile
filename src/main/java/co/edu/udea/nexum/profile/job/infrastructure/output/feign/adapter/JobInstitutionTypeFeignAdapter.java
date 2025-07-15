package co.edu.udea.nexum.profile.job.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.job.domain.model.JobInstitutionType;
import co.edu.udea.nexum.profile.job.domain.spi.JobInstitutionTypePersistencePort;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.client.JobInstitutionTypeFeign;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.mapper.response.JobInstitutionTypeFeignResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobInstitutionTypeFeignAdapter implements JobInstitutionTypePersistencePort {

    private final JobInstitutionTypeFeign jobInstitutionTypeFeign;
    private final JobInstitutionTypeFeignResponseMapper jobInstitutionTypeFeignResponseMapper;

    @Override
    public JobInstitutionType findById(Long id) {
        return jobInstitutionTypeFeignResponseMapper.toDomain(
                jobInstitutionTypeFeign.findById(id)
        );
    }
}
