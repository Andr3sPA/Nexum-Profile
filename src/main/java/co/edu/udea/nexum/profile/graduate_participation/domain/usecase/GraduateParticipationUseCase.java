package co.edu.udea.nexum.profile.graduate_participation.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.graduate_participation.domain.api.GraduateParticipationServicePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;
import co.edu.udea.nexum.profile.graduate_participation.domain.spi.GraduateParticipationPersistencePort;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper.validateCommonUserPermission;

public class GraduateParticipationUseCase
        extends AuditableCrudUseCase<Long, GraduateParticipation>
        implements GraduateParticipationServicePort {

    private final GraduateParticipationPersistencePort persistencePort;
    private final UserPersistencePort userPersistencePort;

    public GraduateParticipationUseCase(
            GraduateParticipationPersistencePort persistencePort,
            UserPersistencePort userPersistencePort
    ) {
        this.persistencePort = persistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    protected BaseCrudPersistencePort<Long, GraduateParticipation> getPersistencePort() {
        return persistencePort;
    }

    @Override
    protected String getModelClassName() {
        return GraduateParticipation.class.getSimpleName();
    }

    @Override
    public List<GraduateParticipation> findByUserId(UUID userId) {
        return persistencePort.findByUserId(userId);
    }

    @Override
    protected GraduateParticipation patch(GraduateParticipation original, GraduateParticipation patch) {
        replaceIfNotNull(patch.getContinuousEducationInterests(), original::setContinuousEducationInterests);
        replaceIfNotNull(patch.getWillingToBeSpeaker(), original::setWillingToBeSpeaker);
        replaceIfNotNull(patch.getWillingToBeProfessor(), original::setWillingToBeProfessor);
        replaceIfNotNull(patch.getWillingToTeachNonFormalEducation(), original::setWillingToTeachNonFormalEducation);
        replaceIfNotNull(patch.getWillingToBePostgraduateStudent(), original::setWillingToBePostgraduateStudent);
        replaceIfNotNull(patch.getWillingToBeNonFormalStudent(), original::setWillingToBeNonFormalStudent);
        replaceIfNotNull(patch.getWillingToBeGraduateRepresentative(), original::setWillingToBeGraduateRepresentative);
        replaceIfNotNull(patch.getWillingToAttendAlumniMeetings(), original::setWillingToAttendAlumniMeetings);
        replaceIfNotNull(patch.getWillingToParticipateInAlumniActivities(), original::setWillingToParticipateInAlumniActivities);
        return original;
    }

    @Override
    protected void validateEntity(Long currentId, GraduateParticipation model) {
        UUID userId = model.getUser().getId();
        validateCommonUserPermission(userId);

        if (!userPersistencePort.existsById(userId)) {
            throw new EntityNotFoundException(User.class.getSimpleName());
        }
    }
}
