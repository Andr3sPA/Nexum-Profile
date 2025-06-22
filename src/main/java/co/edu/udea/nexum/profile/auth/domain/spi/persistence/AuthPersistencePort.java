package co.edu.udea.nexum.profile.auth.domain.spi.persistence;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;

import java.util.UUID;

public interface AuthPersistencePort extends BaseCrudPersistencePort<UUID, Auth> {
    Auth findByEmail(String email);
}
