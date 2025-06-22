package co.edu.udea.nexum.profile.coursed_program.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.BaseCrudUseCase;
import co.edu.udea.nexum.profile.coursed_program.domain.api.CoursedProgramServicePort;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

public class CoursedProgramUseCase
        extends BaseCrudUseCase<Long, CoursedProgram>
        implements CoursedProgramServicePort {
    private final CoursedProgramPersistencePort coursedProgramPersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final ProgramVersionPersistencePort programVersionPersistencePort;

    public CoursedProgramUseCase(
            CoursedProgramPersistencePort coursedProgramPersistencePort,
            UserPersistencePort userPersistencePort,
            ProgramVersionPersistencePort programVersionPersistencePort
    ) {
        this.coursedProgramPersistencePort = coursedProgramPersistencePort;
        this.userPersistencePort = userPersistencePort;
        this.programVersionPersistencePort = programVersionPersistencePort;
    }

    @Override
    public CoursedProgram save(CoursedProgram coursedProgram) {
        ProgramVersion programVersion = programVersionPersistencePort.findById(coursedProgram.getProgramVersion().getId());
        CoursedProgram saved = super.save(coursedProgram);
        saved.setProgramVersion(programVersion);
        return saved;
    }

    @Override
    public CoursedProgram updateById(Long id, CoursedProgram coursedProgram) {
        ProgramVersion programVersion = programVersionPersistencePort.findById(coursedProgram.getProgramVersion().getId());
        CoursedProgram updated = super.updateById(id, coursedProgram);
        updated.setProgramVersion(programVersion);
        return updated;
    }

    @Override
    protected BaseCrudPersistencePort<Long, CoursedProgram> getPersistencePort() {
        return coursedProgramPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return CoursedProgram.class.getSimpleName();
    }

    @Override
    protected void validateEntity(Long currentId, CoursedProgram coursedProgram) {
        if (!userPersistencePort.existsById(coursedProgram.getUser().getId())) {
            throw new EntityNotFoundException(User.class.getSimpleName());
        }
    }

}
