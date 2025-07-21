package co.edu.udea.nexum.profile.program_opinion.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.program_opinion.domain.api.ProgramOpinionServicePort;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;
import co.edu.udea.nexum.profile.program_opinion.domain.spi.ProgramOpinionPersistencePort;

import java.time.Duration;

import static co.edu.udea.nexum.profile.common.domain.utils.constants.CommonDomainConstants.OUTDATED_THRESHOLD;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.updateOrCreateNewIfOutdated;
import static co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper.validateCommonUserPermission;


public class ProgramOpinionUseCase extends AuditableCrudUseCase<Long, ProgramOpinion> implements ProgramOpinionServicePort {
    private final ProgramOpinionPersistencePort programOpinionPersistencePort;
    private final CoursedProgramPersistencePort coursedProgramPersistencePort;

    public ProgramOpinionUseCase(
            ProgramOpinionPersistencePort programOpinionPersistencePort,
            CoursedProgramPersistencePort coursedProgramPersistencePort
    ) {
        this.programOpinionPersistencePort = programOpinionPersistencePort;
        this.coursedProgramPersistencePort = coursedProgramPersistencePort;
    }

    @Override
    public ProgramOpinion updateById(Long id, ProgramOpinion model) {
        validateEntity(id, model);
        ProgramOpinion updated = patch(super.findById(id), model);
        return updateOrCreateNewIfOutdated(
                updated,
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
    protected ProgramOpinion patch(ProgramOpinion original, ProgramOpinion patch) {
        replaceIfNotNull(patch.getCoursedProgram(), original::setCoursedProgram);
        replaceIfNotNull(patch.getStrengths(), original::setStrengths);
        replaceIfNotNull(patch.getWeaknesses(), original::setWeaknesses);
        replaceIfNotNull(patch.getSuggestedCompetencies(), original::setSuggestedCompetencies);
        original.setWhatsappGroupMember(patch.isWhatsappGroupMember());
        return original;
    }


    @Override
    protected void validateEntity(Long currentId, ProgramOpinion programOpinion) {
        CoursedProgram coursedProgram = coursedProgramPersistencePort.findById(programOpinion.getCoursedProgram().getId());
        if (coursedProgram == null) throw new EntityNotFoundException(CoursedProgram.class.getSimpleName());

        validateCommonUserPermission(coursedProgram.getUser().getId());
    }
}
