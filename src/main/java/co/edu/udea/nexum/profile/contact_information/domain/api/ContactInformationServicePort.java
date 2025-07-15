package co.edu.udea.nexum.profile.contact_information.domain.api;

import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;

import java.util.UUID;

public interface ContactInformationServicePort extends BaseCrudServicePort<Long, ContactInformation> {
    ContactInformation findCurrentByUserId(UUID userId);
    ContactInformation findFirstByUserId(UUID userId);
}
