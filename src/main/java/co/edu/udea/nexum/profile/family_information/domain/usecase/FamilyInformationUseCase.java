package co.edu.udea.nexum.profile.family_information.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.family_information.domain.api.FamilyInformationServicePort;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import co.edu.udea.nexum.profile.family_information.domain.spi.FamilyInformationPersistencePort;

import java.time.Duration;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.domain.utils.constants.CommonDomainConstants.OUTDATED_THRESHOLD;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.updateOrCreateNewIfOutdated;
import static co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper.validateCommonUserPermission;

public class FamilyInformationUseCase extends AuditableCrudUseCase<Long, FamilyInformation> implements FamilyInformationServicePort {
    private final FamilyInformationPersistencePort familyInformationPersistencePort;

    public FamilyInformationUseCase(
            FamilyInformationPersistencePort familyInformationPersistencePort
    ) {
        this.familyInformationPersistencePort = familyInformationPersistencePort;
    }

    @Override
    public FamilyInformation updateById(Long id, FamilyInformation familyInformation) {
        validateEntity(id, familyInformation);
        FamilyInformation patched = patch(super.findById(id), familyInformation);

        return updateOrCreateNewIfOutdated(
                patched,
                Duration.ofDays(OUTDATED_THRESHOLD),
                familyInformationPersistencePort::save,
                familyInformationPersistencePort::update
        );
    }

    @Override
    protected BaseCrudPersistencePort<Long, FamilyInformation> getPersistencePort() {
        return familyInformationPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return FamilyInformation.class.getSimpleName();
    }

    @Override
    protected FamilyInformation patch(FamilyInformation original, FamilyInformation patch) {
        replaceIfNotNull(patch.getUser(), original::setUser);
        replaceIfNotNull(patch.getMaritalState(), original::setMaritalState);
        replaceIfNotNull(patch.getChildNumber(), original::setChildNumber);
        return original;
    }

    @Override
    protected void validateEntity(Long currentId, FamilyInformation familyInformation) {
        validateCommonUserPermission(familyInformation.getUser().getId());
    }

    @Override
    public FamilyInformation findLastByUserId(UUID userId) {
        validateCommonUserPermission(userId);
        return familyInformationPersistencePort.findLastByUserId(userId);
    }
}
