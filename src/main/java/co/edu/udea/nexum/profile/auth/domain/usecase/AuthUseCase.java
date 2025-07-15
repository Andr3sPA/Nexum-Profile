package co.edu.udea.nexum.profile.auth.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.api.AuthServicePort;
import co.edu.udea.nexum.profile.auth.domain.exception.BadCredentialsException;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.model.AuthorizationData;
import co.edu.udea.nexum.profile.auth.domain.model.Role;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.RolePersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.exception.EntityAlreadyExistsException;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

import java.time.LocalDateTime;

import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.EMAIL_ATTRIBUTE;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.IDENTITY_DOCUMENT_ATTRIBUTE;

public class AuthUseCase implements AuthServicePort {
    private final AuthPersistencePort authPersistencePort;
    private final AuthenticationSecurityPort authenticationSecurityPort;
    private final RolePersistencePort rolePersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;

    public AuthUseCase(
            AuthPersistencePort authPersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort,
            RolePersistencePort rolePersistencePort,
            UserPersistencePort userPersistencePort, IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort
    ) {
        this.authPersistencePort = authPersistencePort;
        this.authenticationSecurityPort = authenticationSecurityPort;
        this.rolePersistencePort = rolePersistencePort;
        this.userPersistencePort = userPersistencePort;
        this.identityDocumentTypePersistencePort = identityDocumentTypePersistencePort;
    }

    @Override
    public User registerAdministrative(Auth auth, User user) {
        Role role = rolePersistencePort.findByName(RoleName.ADMINISTRATIVE);
        auth.setRole(role);
        return register(auth, user);
    }

    @Override
    public User registerGraduate(Auth auth, User user) {
        Role role = rolePersistencePort.findByName(RoleName.GRADUATE);
        auth.setRole(role);
        return register(auth, user);
    }

    @Override
    public AuthenticatedUser login(String email, String password) {
        try {
            Auth user = authPersistencePort.findByEmail(email);
            if (user == null) throw new EntityNotFoundException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, email);
            return authenticationSecurityPort.authenticate(user, AuthorizationData.builder()
                    .id(user.getId())
                    .password(password)
                    .build());
        } catch (RuntimeException e) {
            throw new BadCredentialsException();
        }
    }

    @Override
    public AuthenticatedUser getAuthenticatedUser() {
        return authenticationSecurityPort.getAuthenticatedUser();
    }

    private User register(Auth auth, User user) {
        IdentityDocumentType type = identityDocumentTypePersistencePort.findById(user.getIdentityDocumentType().getId());
        validateUser(user);
        LocalDateTime now = LocalDateTime.now();
        user.setCreationDate(now);
        user.setLastUpdate(now);
        User savedUser = userPersistencePort.save(user);
        savedUser.setIdentityDocumentType(type);

        auth.setUser(savedUser);
        auth.setCreationDate(now);
        auth.setLastUpdate(now);
        validateAuth(auth);
        authPersistencePort.save(auth);

        return savedUser;
    }

    private void validateAuth(Auth auth) {
        Auth user = authPersistencePort.findByEmail(auth.getEmail());
        if (user != null)
            throw new EntityAlreadyExistsException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, auth.getEmail());
    }

    private void validateUser(User user) {
        if (userPersistencePort.existsByIdentityDocument(user.getIdentityDocument()))
            throw new EntityAlreadyExistsException(User.class.getSimpleName(), IDENTITY_DOCUMENT_ATTRIBUTE, user.getIdentityDocument());
    }
}
