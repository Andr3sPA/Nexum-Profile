package co.edu.udea.nexum.profile.user.domain.api;

import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.basic.BasicUser;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;

import java.util.UUID;

public interface UserServicePort extends BaseCrudServicePort<UUID, User> {
    User findAuthenticatedUser();
    DomainPage<BasicUser> findAllFiltered(UserFilter filter, PaginationData paginationData);
}
