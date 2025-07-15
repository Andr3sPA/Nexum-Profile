package co.edu.udea.nexum.profile.coursed_program.domain.spi;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;

import java.util.List;
import java.util.UUID;

public interface CoursedProgramPersistencePort extends BaseCrudPersistencePort<Long, CoursedProgram> {
    List<CoursedProgram> findAllByUserId(UUID id);
}
