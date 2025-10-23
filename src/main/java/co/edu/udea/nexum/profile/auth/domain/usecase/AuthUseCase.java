package co.edu.udea.nexum.profile.auth.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.api.AuthServicePort;
import co.edu.udea.nexum.profile.auth.domain.exception.BadCredentialsException;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.model.AuthorizationData;
import co.edu.udea.nexum.profile.auth.domain.model.Role;
import co.edu.udea.nexum.profile.auth.domain.spi.email.EmailServicePort;
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
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.EMAIL_ATTRIBUTE;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.IDENTITY_DOCUMENT_ATTRIBUTE;

public class AuthUseCase implements AuthServicePort {
    private final AuthPersistencePort authPersistencePort;
    private final AuthenticationSecurityPort authenticationSecurityPort;
    private final RolePersistencePort rolePersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;
    private final EmailServicePort emailServicePort;
    private final PasswordEncoder passwordEncoder;

    public AuthUseCase(
            AuthPersistencePort authPersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort,
            RolePersistencePort rolePersistencePort,
            UserPersistencePort userPersistencePort,
            IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort,
            EmailServicePort emailServicePort,
            PasswordEncoder passwordEncoder
    ) {
        this.authPersistencePort = authPersistencePort;
        this.authenticationSecurityPort = authenticationSecurityPort;
        this.rolePersistencePort = rolePersistencePort;
        this.userPersistencePort = userPersistencePort;
        this.identityDocumentTypePersistencePort = identityDocumentTypePersistencePort;
        this.emailServicePort = emailServicePort;
        this.passwordEncoder = passwordEncoder;
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
    public User registerEmployer(Auth auth, User user) {
        Role role = rolePersistencePort.findByName(RoleName.EMPLOYER);
        auth.setRole(role);
        return register(auth, user);
    }

    @Override
    public AuthenticatedUser login(String email, String password) {
        try {
            Auth user = authPersistencePort.findByEmail(email);
            if (user == null) throw new EntityNotFoundException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, email);
            if (!user.isVerified()) throw new BadCredentialsException(); // Or create a specific exception
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

    @Override
    public Auth getByUserId(UUID userId) {
        return authPersistencePort.findByUserId(userId);
    }

    @Override
    public void verifyAccount(String email, String token) {
        Auth auth = authPersistencePort.findByEmail(email);
        if (auth == null) throw new EntityNotFoundException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, email);
        // token must match the one stored for that email
        if (auth.getVerificationToken() == null || !auth.getVerificationToken().equals(token))
            throw new EntityNotFoundException("Verification token not found");
        auth.setVerified(true);
        auth.setVerificationToken(null);
        auth.setLastUpdate(LocalDateTime.now());
        authPersistencePort.save(auth);
    }

    @Override
    public void requestPasswordReset(String email) {
        Auth auth = authPersistencePort.findByEmail(email);
        if (auth == null) throw new EntityNotFoundException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, email);
        if (!auth.isVerified()) throw new RuntimeException("Account not verified"); // Or specific exception
        String token = java.util.UUID.randomUUID().toString();
        auth.setVerificationToken(token);
        auth.setLastUpdate(LocalDateTime.now());
        authPersistencePort.save(auth);
        emailServicePort.sendPasswordResetEmail(email, token);
    }

    @Override
    public void resendVerification(String email) {
        Auth auth = authPersistencePort.findByEmail(email);
        if (auth == null) throw new EntityNotFoundException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, email);
        // If already verified, do nothing
        if (auth.isVerified()) {
            return;
        }
        String token = java.util.UUID.randomUUID().toString();
        auth.setVerificationToken(token);
        auth.setLastUpdate(LocalDateTime.now());
        authPersistencePort.save(auth);
        emailServicePort.sendVerificationEmail(email, token);
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        Auth auth = authPersistencePort.findByVerificationToken(token);
        if (auth == null) throw new EntityNotFoundException("Reset token not found");
        if (!auth.isVerified()) throw new RuntimeException("Account not verified");
        auth.setPassword(passwordEncoder.encode(newPassword)); // Need to inject PasswordEncoder
        auth.setVerificationToken(null);
        auth.setLastUpdate(LocalDateTime.now());
        authPersistencePort.save(auth);
    }

    private User register(Auth auth, User user) {
        // If the identity document type id is 7 (NIT), avoid a remote call and construct
        // the IdentityDocumentType locally to reduce outbound Feign calls for the
        // common employer flow. Otherwise, fetch the type using the persistence port.
        IdentityDocumentType type;
        Long providedTypeId = user.getIdentityDocumentType() != null ? user.getIdentityDocumentType().getId() : null;
        if (providedTypeId != null && providedTypeId.equals(7L)) {
            type = IdentityDocumentType.builder()
                    .id(7L)
                    .documentType(co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType.NIT)
                    .build();
        } else {
            type = identityDocumentTypePersistencePort.findById(providedTypeId);
        }
        LocalDateTime now = LocalDateTime.now();

        User existingUser = userPersistencePort.findByIdentityDocument(user.getIdentityDocument());

        if (existingUser != null) return registerAuthForExistingUser(auth, existingUser, type, now);
        return registerNewUserAndAuth(auth, user, type, now);
    }

    private void setupVerification(Auth auth) {
        auth.setVerified(false);
        auth.setVerificationToken(java.util.UUID.randomUUID().toString());
        authPersistencePort.save(auth);
        emailServicePort.sendVerificationEmail(auth.getEmail(), auth.getVerificationToken());
    }


    private void validateAuth(Auth auth) {
        Auth user = authPersistencePort.findByEmail(auth.getEmail());
        if (user != null)
            throw new EntityAlreadyExistsException(Auth.class.getSimpleName(), EMAIL_ATTRIBUTE, auth.getEmail());
    }

    private User registerNewUserAndAuth(Auth auth, User user, IdentityDocumentType type, LocalDateTime now) {
        validateAuth(auth);

        user.setCreationDate(now);
        user.setLastUpdate(now);
        User savedUser = userPersistencePort.save(user);
        savedUser.setIdentityDocumentType(type);

        auth.setUser(savedUser);
        auth.setCreationDate(now);
        auth.setLastUpdate(now);
        // Save auth but DO NOT send verification email here. The verification token
        // will be generated and sent only when the client calls the resend/obtain endpoint.
        auth.setVerified(false);
        auth.setVerificationToken(null);
        Auth savedAuth = authPersistencePort.save(auth);

        return savedUser;
    }

    private User registerAuthForExistingUser(Auth auth, User existingUser, IdentityDocumentType type, LocalDateTime now) {
        if (authPersistencePort.findByUserId(existingUser.getId()) != null) throw new EntityAlreadyExistsException(
                User.class.getSimpleName(),
                IDENTITY_DOCUMENT_ATTRIBUTE,
                existingUser.getIdentityDocument()
        );

        validateAuth(auth);

        existingUser.setIdentityDocumentType(type);
        auth.setUser(existingUser);
        auth.setCreationDate(now);
        auth.setLastUpdate(now);
        // Save auth for existing user, but do NOT send verification email automatically.
        auth.setVerified(false);
        auth.setVerificationToken(null);
        Auth savedAuth = authPersistencePort.save(auth);

        return existingUser;
    }


}
