package co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;
import co.edu.udea.nexum.profile.graduate_participation.domain.spi.GraduateParticipationPersistencePort;
import co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.entity.GraduateParticipationEntity;
import co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.mapper.GraduateParticipationEntityMapper;
import co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.repository.GraduateParticipationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GraduateParticipationJpaAdapter
        extends BaseCrudAdapterImpl<Long, GraduateParticipation, GraduateParticipationEntity>
        implements GraduateParticipationPersistencePort {

    private final GraduateParticipationRepository repository;
    private final GraduateParticipationEntityMapper mapper;

    @Override
    protected BaseEntityMapper<GraduateParticipation, GraduateParticipationEntity> getMapper() {
        return mapper;
    }

    @Override
    protected CrudRepository<GraduateParticipationEntity, Long> getRepository() {
        return repository;
    }

    @Override
    public List<GraduateParticipation> findByUserId(UUID userId) {
        return mapper.toDomains(repository.findAllByUser_Id(userId));
    }

    @Override
    public List<GraduateParticipation> findByUserIdOrderByDateDesc(UUID userId) {
        return mapper.toDomains(
                repository.findAllByUser_IdOrderByCreationDateDesc(userId)
        );
    }
}
