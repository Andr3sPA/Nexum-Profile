package co.edu.udea.nexum.profile.user.domain.spi;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.util.UUID;

public interface UserPersistencePort extends BaseCrudPersistencePort<UUID, User> {
    boolean existsById(UUID id);
    boolean existsByIdentityDocument(String identityDocument);
    User findByIdentityDocument(String identityDocument);
}
