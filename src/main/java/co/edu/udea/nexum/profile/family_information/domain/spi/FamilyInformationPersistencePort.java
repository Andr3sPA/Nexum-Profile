package co.edu.udea.nexum.profile.family_information.domain.spi;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;

import java.util.UUID;

public interface FamilyInformationPersistencePort extends BaseCrudPersistencePort<Long, FamilyInformation> {
    FamilyInformation findLastByUserId(UUID userId);
}
