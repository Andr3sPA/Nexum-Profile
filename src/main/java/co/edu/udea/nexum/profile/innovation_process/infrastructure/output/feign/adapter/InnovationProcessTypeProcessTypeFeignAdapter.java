package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessTypePersistencePort;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.client.InnovationProcessTypeFeign;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.mapper.response.InnovationProcessTypeFeignResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InnovationProcessTypeProcessTypeFeignAdapter implements InnovationProcessTypePersistencePort {

    private final InnovationProcessTypeFeign client;
    private final InnovationProcessTypeFeignResponseMapper mapper;

    @Override
    public InnovationProcessType findById(Long id) {
        return mapper.toDomain(client.findById(id));
    }

    @Override
    public List<InnovationProcessType> findByIds(List<Long> ids) {
        return mapper.toDomains(client.findByIds(ids));
    }
}
