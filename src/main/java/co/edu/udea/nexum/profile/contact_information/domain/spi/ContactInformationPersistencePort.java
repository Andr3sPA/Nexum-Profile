package co.edu.udea.nexum.profile.contact_information.domain.spi;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;

import java.util.UUID;

public interface ContactInformationPersistencePort extends BaseCrudPersistencePort<Long, ContactInformation> {
    ContactInformation findCurrentByUserId(UUID userId);
    ContactInformation findFirstByUserId(UUID userId);
}
