package co.edu.udea.nexum.profile.family_information.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.common.domain.exception.ForbiddenResourceAccessException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.BaseCrudUseCase;
import co.edu.udea.nexum.profile.family_information.domain.api.FamilyInformationServicePort;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import co.edu.udea.nexum.profile.family_information.domain.spi.FamilyInformationPersistencePort;

import java.time.Duration;
import java.time.LocalDateTime;

import static co.edu.udea.nexum.profile.common.domain.utils.constants.CommonDomainConstants.OUTDATED_THRESHOLD;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.updateOrCreateNewIfOutdated;

public class FamilyInformationUseCase extends BaseCrudUseCase<Long, FamilyInformation> implements FamilyInformationServicePort {
    private final FamilyInformationPersistencePort familyInformationPersistencePort;
    private final AuthenticationSecurityPort authenticationSecurityPort;

    public FamilyInformationUseCase(
            FamilyInformationPersistencePort familyInformationPersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort
    ) {
        this.familyInformationPersistencePort = familyInformationPersistencePort;
        this.authenticationSecurityPort = authenticationSecurityPort;
    }

    @Override
    public FamilyInformation save(FamilyInformation model) {
        model.setCreationDate(LocalDateTime.now());
        model.setLastUpdate(LocalDateTime.now());
        return super.save(model);
    }

    @Override
    public FamilyInformation updateById(Long id, FamilyInformation model) {
        validateEntity(id, model);
        FamilyInformation existingFamilyInformation = super.findById(id);

        return updateOrCreateNewIfOutdated(
                id, model, existingFamilyInformation,
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
    protected void validateEntity(Long currentId, FamilyInformation model) {
        AuthenticatedUser user = authenticationSecurityPort.getAuthenticatedUser();
        if (!model.getUser().getId().equals(user.getId())) throw new ForbiddenResourceAccessException();
    }
}
