package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity.CoursedProgramEntity;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.mapper.CoursedProgramEntityMapper;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.repository.CoursedProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CoursedProgramJpaAdapter extends BaseCrudAdapterImpl<Long, CoursedProgram, CoursedProgramEntity> implements CoursedProgramPersistencePort {
    private final CoursedProgramRepository coursedProgramRepository;
    private final CoursedProgramEntityMapper coursedProgramEntityMapper;

    @Override
    protected BaseEntityMapper<CoursedProgram, CoursedProgramEntity> getMapper() {
        return coursedProgramEntityMapper;
    }

    @Override
    protected CrudRepository<CoursedProgramEntity, Long> getRepository() {
        return coursedProgramRepository;
    }

    @Override
    public List<CoursedProgram> findAllByUserId(UUID id) {
        return coursedProgramEntityMapper.toDomains(
                coursedProgramRepository.findAllByUser_Id(id)
        );
    }
}
