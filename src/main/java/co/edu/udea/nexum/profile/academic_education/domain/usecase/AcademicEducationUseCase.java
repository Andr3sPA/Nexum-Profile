package co.edu.udea.nexum.profile.academic_education.domain.usecase;

import co.edu.udea.nexum.profile.academic_education.domain.api.AcademicEducationServicePort;
import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.academic_education.domain.spi.AcademicEducationPersistencePort;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper.validateCommonUserPermission;

public class AcademicEducationUseCase
        extends AuditableCrudUseCase<Long, AcademicEducation>
        implements AcademicEducationServicePort {

    private final AcademicEducationPersistencePort academicEducationPersistencePort;
    private final UserPersistencePort userPersistencePort;

    public AcademicEducationUseCase(
            AcademicEducationPersistencePort academicEducationPersistencePort,
            UserPersistencePort userPersistencePort
    ) {
        this.academicEducationPersistencePort = academicEducationPersistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    protected BaseCrudPersistencePort<Long, AcademicEducation> getPersistencePort() {
        return academicEducationPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return AcademicEducation.class.getSimpleName();
    }

    @Override
    protected AcademicEducation patch(AcademicEducation original, AcademicEducation patch) {
        replaceIfNotNull(patch.getUser(), original::setUser);
        replaceIfNotNull(patch.getType(), original::setType);
        replaceIfNotNull(patch.getStudyName(), original::setStudyName);
        replaceIfNotNull(patch.getInstitution(), original::setInstitution);
        replaceIfNotNull(patch.getCountry(), original::setCountry);
        return original;
    }

    @Override
    protected void validateEntity(Long currentId, AcademicEducation model) {
        validateCommonUserPermission(model.getUser().getId());
        if (!userPersistencePort.existsById(model.getUser().getId()))
            throw new EntityNotFoundException(User.class.getSimpleName());
    }
}
