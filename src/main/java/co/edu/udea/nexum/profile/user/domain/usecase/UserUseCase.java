package co.edu.udea.nexum.profile.user.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.common.domain.exception.EntityAlreadyExistsException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.domain.api.UserServicePort;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

import java.util.UUID;

import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.IDENTITY_DOCUMENT_ATTRIBUTE;

public class UserUseCase extends AuditableCrudUseCase<UUID, User> implements UserServicePort {
    private final UserPersistencePort userPersistencePort;
    private final IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;
    private final AuthenticationSecurityPort authenticationSecurityPort;
    private final AuthPersistencePort authPersistencePort;

    public UserUseCase(
            UserPersistencePort userPersistencePort,
            IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort,
            AuthPersistencePort authPersistencePort
    ) {
        this.userPersistencePort = userPersistencePort;
        this.identityDocumentTypePersistencePort = identityDocumentTypePersistencePort;
        this.authenticationSecurityPort = authenticationSecurityPort;
        this.authPersistencePort = authPersistencePort;
    }

    @Override
    public User findById(UUID uuid) {
        User user = super.findById(uuid);
        IdentityDocumentType type = identityDocumentTypePersistencePort.findById(user.getIdentityDocumentType().getId());
        user.setIdentityDocumentType(type);
        return user;
    }
    @Override
    protected BaseCrudPersistencePort<UUID, User> getPersistencePort() {
        return userPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return User.class.getSimpleName();
    }

    @Override
    protected User loadAssociations(User user) {
        IdentityDocumentType type = identityDocumentTypePersistencePort.findById(user.getIdentityDocumentType().getId());
        user.setIdentityDocumentType(type);
        return user;
    }

    @Override
    protected User patch(User original, final User patch) {
            replaceIfNotNull(patch.getIdentityDocument(), original::setIdentityDocument);
            replaceIfNotNull(patch.getIdentityDocumentType(), original::setIdentityDocumentType);
            replaceIfNotNull(patch.getName(), original::setName);
            replaceIfNotNull(patch.getMiddleName(), original::setMiddleName);
            replaceIfNotNull(patch.getLastname(), original::setLastname);
            replaceIfNotNull(patch.getSecondLastname(), original::setSecondLastname);
            replaceIfNotNull(patch.getBirthdate(), original::setBirthdate);
            replaceIfNotNull(patch.getGender(), original::setGender);
            replaceIfNotNull(patch.getInstitutionalEmail(), original::setInstitutionalEmail);
            return original;
    }

    @Override
    protected void validateEntity(UUID currentId, User user) {
        User existingByDocument = userPersistencePort.findByIdentityDocument(user.getIdentityDocument());
        if (existingByDocument != null && !existingByDocument.getId().equals(currentId))
            throw new EntityAlreadyExistsException(getModelClassName(), IDENTITY_DOCUMENT_ATTRIBUTE, user.getIdentityDocument());
    }

    @Override
    public User findAuthenticatedUser() {
        AuthenticatedUser authenticatedUser = authenticationSecurityPort.getAuthenticatedUser();
        Auth auth = authPersistencePort.findById(authenticatedUser.getId());
        return findById(auth.getUser().getId());
    }
}
