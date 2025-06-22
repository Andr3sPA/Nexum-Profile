package co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;
import co.edu.udea.nexum.profile.program_opinion.domain.spi.ProgramOpinionPersistencePort;
import co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.entity.ProgramOpinionEntity;
import co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.mapper.ProgramOpinionEntityMapper;
import co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.repository.ProgramOpinionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgramOpinionJpaAdapter extends BaseCrudAdapterImpl<Long, ProgramOpinion, ProgramOpinionEntity> implements ProgramOpinionPersistencePort {

    private final ProgramOpinionRepository programOpinionRepository;
    private final ProgramOpinionEntityMapper programOpinionEntityMapper;

    @Override
    protected BaseEntityMapper<ProgramOpinion, ProgramOpinionEntity> getMapper() {
        return programOpinionEntityMapper;
    }

    @Override
    protected CrudRepository<ProgramOpinionEntity, Long> getRepository() {
        return programOpinionRepository;
    }
}
