package co.edu.udea.nexum.profile.program_opinion.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.exception.ForbiddenResourceAccessException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.BaseCrudUseCase;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.program_opinion.domain.api.ProgramOpinionServicePort;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;
import co.edu.udea.nexum.profile.program_opinion.domain.spi.ProgramOpinionPersistencePort;

import java.time.Duration;
import java.time.LocalDateTime;

import static co.edu.udea.nexum.profile.common.domain.utils.constants.CommonDomainConstants.OUTDATED_THRESHOLD;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.updateOrCreateNewIfOutdated;


public class ProgramOpinionUseCase extends BaseCrudUseCase<Long, ProgramOpinion> implements ProgramOpinionServicePort {
    private final ProgramOpinionPersistencePort programOpinionPersistencePort;
    private final CoursedProgramPersistencePort coursedProgramPersistencePort;
    private final AuthenticationSecurityPort authenticationSecurityPort;

    public ProgramOpinionUseCase(ProgramOpinionPersistencePort programOpinionPersistencePort, CoursedProgramPersistencePort coursedProgramPersistencePort, AuthenticationSecurityPort authenticationSecurityPort) {
        this.programOpinionPersistencePort = programOpinionPersistencePort;
        this.coursedProgramPersistencePort = coursedProgramPersistencePort;
        this.authenticationSecurityPort = authenticationSecurityPort;
    }

    @Override
    public ProgramOpinion save(ProgramOpinion model) {
        model.setCreationDate(LocalDateTime.now());
        model.setLastUpdate(LocalDateTime.now());
        return super.save(model);
    }

    @Override
    public ProgramOpinion updateById(Long id, ProgramOpinion model) {
        validateEntity(id, model);
        ProgramOpinion existingOpinion = super.findById(id);
        return updateOrCreateNewIfOutdated(
                id, model, existingOpinion,
                Duration.ofDays(OUTDATED_THRESHOLD),
                programOpinionPersistencePort::save,
                programOpinionPersistencePort::update
        );
    }

    @Override
    protected BaseCrudPersistencePort<Long, ProgramOpinion> getPersistencePort() {
        return programOpinionPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return ProgramOpinion.class.getSimpleName();
    }

    @Override
    protected void validateEntity(Long currentId, ProgramOpinion programOpinion) {
        CoursedProgram coursedProgram = coursedProgramPersistencePort.findById(programOpinion.getCoursedProgram().getId());
        if (coursedProgram == null) throw new EntityNotFoundException(CoursedProgram.class.getSimpleName());

        AuthenticatedUser user = authenticationSecurityPort.getAuthenticatedUser();
        if (!coursedProgram.getUser().getId().equals(user.getId())) throw new ForbiddenResourceAccessException();
    }
}
