package co.edu.udea.nexum.profile.auth.domain.api;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.filter.AuthFilter;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;

import java.util.UUID;

public interface AuthCrudServicePort extends BaseCrudServicePort<UUID, Auth> {
    DomainPage<Auth> findAll(AuthFilter filter, PaginationData paginationData);
}
