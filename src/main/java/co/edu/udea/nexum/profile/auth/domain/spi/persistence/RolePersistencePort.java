package co.edu.udea.nexum.profile.auth.domain.spi.persistence;

import co.edu.udea.nexum.profile.auth.domain.model.Role;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;

public interface RolePersistencePort extends BaseCrudPersistencePort<Long, Role> {
    Role findByName(RoleName name);
}
