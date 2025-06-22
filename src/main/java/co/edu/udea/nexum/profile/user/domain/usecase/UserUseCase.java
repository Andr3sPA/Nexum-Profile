package co.edu.udea.nexum.profile.user.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.exception.EntityAlreadyExistsException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.BaseCrudUseCase;
import co.edu.udea.nexum.profile.user.domain.api.UserServicePort;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.IDENTITY_DOCUMENT_ATTRIBUTE;

public class UserUseCase extends BaseCrudUseCase<UUID, User> implements UserServicePort {
    private final UserPersistencePort userPersistencePort;
    private final IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort, IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.identityDocumentTypePersistencePort = identityDocumentTypePersistencePort;
    }

    @Override
    public User save(User model) {
        IdentityDocumentType type = identityDocumentTypePersistencePort.findById(model.getIdentityDocumentType().getId());
        User user = super.save(model);
        user.setIdentityDocumentType(type);
        user.setCreationDate(LocalDateTime.now());
        user.setLastUpdate(LocalDateTime.now());
        return user;
    }

    @Override
    public User findById(UUID uuid) {
        User user = super.findById(uuid);
        IdentityDocumentType type = identityDocumentTypePersistencePort.findById(user.getIdentityDocumentType().getId());
        user.setIdentityDocumentType(type);
        return user;
    }

    @Override
    public User updateById(UUID uuid, User model) {
        IdentityDocumentType type = identityDocumentTypePersistencePort.findById(model.getIdentityDocumentType().getId());
        User user = super.updateById(uuid, model);
        user.setIdentityDocumentType(type);
        user.setLastUpdate(LocalDateTime.now());
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
    protected void validateEntity(UUID currentId, User user) {
        User existingByDocument = userPersistencePort.findByIdentityDocument(user.getIdentityDocument());
        if (existingByDocument != null && !existingByDocument.getId().equals(currentId))
            throw new EntityAlreadyExistsException(getModelClassName(), IDENTITY_DOCUMENT_ATTRIBUTE, user.getIdentityDocument());
    }

}
