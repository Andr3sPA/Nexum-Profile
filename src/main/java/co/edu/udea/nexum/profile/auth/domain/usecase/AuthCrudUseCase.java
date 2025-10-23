package co.edu.udea.nexum.profile.auth.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.api.AuthCrudServicePort;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.Role;
import co.edu.udea.nexum.profile.auth.domain.model.filter.AuthFilter;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.RolePersistencePort;
import co.edu.udea.nexum.profile.common.domain.exception.EntityAlreadyExistsException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;

import java.util.UUID;

import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.EMAIL_ATTRIBUTE;

public class AuthCrudUseCase extends AuditableCrudUseCase<UUID, Auth> implements AuthCrudServicePort {

    private final AuthPersistencePort authPersistencePort;
    private final RolePersistencePort rolePersistencePort;

    public AuthCrudUseCase(
            AuthPersistencePort authPersistencePort,
            RolePersistencePort rolePersistencePort
    ) {
        this.authPersistencePort = authPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    protected BaseCrudPersistencePort<UUID, Auth> getPersistencePort() {
        return authPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return Auth.class.getSimpleName();
    }

    @Override
    protected Auth patch(Auth original, Auth patch) {
        Role role = rolePersistencePort.findByName(patch.getRole().getName());
        replaceIfNotNull(patch.getEmail(), original::setEmail);
        replaceIfNotNull(patch.getPassword(), original::setPassword);
        replaceIfNotNull(role, original::setRole);
        replaceIfNotNull(patch.isVerified(), original::setVerified);
        return original;
    }

    @Override
    protected void validateEntity(UUID currentId, Auth auth) {
        Auth user = authPersistencePort.findByEmail(auth.getEmail());
        if (user != null && !user.getId().equals(currentId))
            throw new EntityAlreadyExistsException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, auth.getEmail());
    }

    @Override
    public DomainPage<Auth> findAll(AuthFilter filter, PaginationData paginationData) {
        return authPersistencePort.findAll(filter, paginationData);
    }
}
