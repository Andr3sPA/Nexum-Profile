package co.edu.udea.nexum.profile.contact_information.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.contact_information.domain.api.ContactInformationServicePort;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.contact_information.domain.spi.ContactInformationPersistencePort;

import java.time.Duration;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.domain.utils.constants.CommonDomainConstants.OUTDATED_THRESHOLD;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.updateOrCreateNewIfOutdated;
import static co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper.validateCommonUserPermission;

public class ContactInformationUseCase extends AuditableCrudUseCase<Long, ContactInformation> implements ContactInformationServicePort {

    private final ContactInformationPersistencePort contactInformationPersistencePort;

    public ContactInformationUseCase(
            ContactInformationPersistencePort contactInformationPersistencePort
    ) {
        this.contactInformationPersistencePort = contactInformationPersistencePort;
    }

    @Override
    public ContactInformation updateById(Long id, ContactInformation contactInformation) {
        validateEntity(id, contactInformation);
        ContactInformation existing = patch(super.findById(id), contactInformation);


        return updateOrCreateNewIfOutdated(
                existing,
                Duration.ofDays(OUTDATED_THRESHOLD),
                contactInformationPersistencePort::save,
                contactInformationPersistencePort::update
        );
    }

    @Override
    protected BaseCrudPersistencePort<Long, ContactInformation> getPersistencePort() {
        return contactInformationPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return ContactInformation.class.getSimpleName();
    }

    @Override
    protected void validateEntity(Long currentId, ContactInformation contactInformation) {
        validateCommonUserPermission(contactInformation.getUser().getId());
    }

    @Override
    public ContactInformation findCurrentByUserId(UUID userId) {
        validateCommonUserPermission(userId);
        return contactInformationPersistencePort.findCurrentByUserId(userId);
    }

    @Override
    public ContactInformation findFirstByUserId(UUID userId) {
        validateCommonUserPermission(userId);
        return contactInformationPersistencePort.findFirstByUserId(userId);
    }

    @Override
    protected ContactInformation patch(ContactInformation original, ContactInformation patch) {
        replaceIfNotNull(patch.getAddress(), original::setAddress);
        replaceIfNotNull(patch.getCountry(), original::setCountry);
        replaceIfNotNull(patch.getState(), original::setState);
        replaceIfNotNull(patch.getCity(), original::setCity);
        replaceIfNotNull(patch.getLandline(), original::setLandline);
        replaceIfNotNull(patch.getMobile(), original::setMobile);
        replaceIfNotNull(patch.getEmail(), original::setEmail);
        replaceIfNotNull(patch.getAcademicEmail(), original::setAcademicEmail);
        replaceIfNotNull(patch.getUser(), original::setUser);
        replaceIfNotNull(patch.getWhatsappAuthorization(), original::setWhatsappAuthorization);
        replaceIfNotNull(patch.getCurrent(), original::setCurrent);

        return original;
    }

}
