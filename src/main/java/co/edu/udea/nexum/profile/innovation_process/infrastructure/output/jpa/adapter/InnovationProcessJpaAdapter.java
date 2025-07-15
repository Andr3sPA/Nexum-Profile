package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessPersistencePort;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.entity.InnovationProcessEntity;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.mapper.InnovationProcessEntityMapper;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.repository.InnovationProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InnovationProcessJpaAdapter extends BaseCrudAdapterImpl<Long, InnovationProcess, InnovationProcessEntity>
        implements InnovationProcessPersistencePort {

    private final InnovationProcessRepository innovationProcessRepository;
    private final InnovationProcessEntityMapper innovationProcessEntityMapper;

    @Override
    protected BaseEntityMapper<InnovationProcess, InnovationProcessEntity> getMapper() {
        return innovationProcessEntityMapper;
    }

    @Override
    protected CrudRepository<InnovationProcessEntity, Long> getRepository() {
        return innovationProcessRepository;
    }

    @Override
    public List<InnovationProcess> findByUserId(UUID userId) {
        return innovationProcessEntityMapper.toDomains(
                innovationProcessRepository.findAllByUser_Id(userId)
        );
    }
}
