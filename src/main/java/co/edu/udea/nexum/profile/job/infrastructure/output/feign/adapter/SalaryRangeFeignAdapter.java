package co.edu.udea.nexum.profile.job.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.job.domain.model.SalaryRange;
import co.edu.udea.nexum.profile.job.domain.spi.SalaryRangePersistencePort;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.client.SalaryRangeFeign;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.mapper.response.SalaryRangeFeignResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalaryRangeFeignAdapter implements SalaryRangePersistencePort {

    private final SalaryRangeFeign salaryRangeFeign;
    private final SalaryRangeFeignResponseMapper salaryRangeFeignResponseMapper;

    @Override
    public SalaryRange findById(Long id) {
        return salaryRangeFeignResponseMapper.toDomain(
                salaryRangeFeign.findById(id)
        );
    }
}
