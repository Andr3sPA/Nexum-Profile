package co.edu.udea.nexum.profile.auth.domain.spi.persistence;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.filter.AuthFilter;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;

import java.util.UUID;

public interface AuthPersistencePort extends BaseCrudPersistencePort<UUID, Auth> {
    Auth findByEmail(String email);
    Auth findByUserId(UUID id);
    DomainPage<Auth> findAll(AuthFilter filter, PaginationData paginationData);
}
