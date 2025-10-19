package co.edu.udea.nexum.profile.auth.application.handler.impl;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthenticationRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.EmployerRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthenticatedUserResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.UserRegisteredResponse;
import co.edu.udea.nexum.profile.auth.application.handler.AuthHandler;
import co.edu.udea.nexum.profile.auth.application.mapper.request.AuthRequestMapper;
import co.edu.udea.nexum.profile.auth.application.mapper.response.AuthResponseMapper;
import co.edu.udea.nexum.profile.auth.application.mapper.response.AuthenticatedUserResponseMapper;
import co.edu.udea.nexum.profile.auth.application.mapper.response.UserRegisteredResponseMapper;
import co.edu.udea.nexum.profile.auth.domain.api.AuthServicePort;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.infrastructure.output.feign.adapter.OpportunityFeignAdapter;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthHandlerImpl implements AuthHandler {
  private final AuthServicePort authServicePort;
  private final AuthRequestMapper authRequestMapper;
  private final AuthResponseMapper authResponseMapper;
  private final AuthenticatedUserResponseMapper authenticatedUserResponseMapper;
  private final UserRegisteredResponseMapper userRegisteredResponseMapper;
  private final PasswordEncoder passwordEncoder;
  private final OpportunityFeignAdapter opportunityFeignAdapter;

  @Override
  public UserRegisteredResponse registerAdministrative(UserRegisterRequest request) {
    User user = authRequestMapper.toDomainUser(request);
    Auth auth = authRequestMapper.toDomainAuth(request);
    auth.setPassword(passwordEncoder.encode(auth.getPassword()));
    return userRegisteredResponseMapper.toResponse(
        authServicePort.registerAdministrative(auth, user));
  }

  @Override
  public UserRegisteredResponse registerGraduate(UserRegisterRequest request) {
    User user = authRequestMapper.toDomainUser(request);
    Auth auth = authRequestMapper.toDomainAuth(request);
    auth.setPassword(passwordEncoder.encode(auth.getPassword()));
    return userRegisteredResponseMapper.toResponse(
        authServicePort.registerGraduate(auth, user));
  }

  @Override
  public UserRegisteredResponse registerEmployer(EmployerRegisterRequest request) {
    // For simplified employer registration, create a basic User and Auth with
    // defaults
    // Use NIT (ID 7) for companies
    IdentityDocumentType nitDocumentType = IdentityDocumentType.builder()
        .id(7L)
        .documentType(DocumentType.NIT)
        .build();

    // Use NIT if provided, otherwise use email as identity document
    String identityDocument = request.getNit() != null && !request.getNit().isEmpty()
        ? request.getNit()
        : request.getEmail();

    User user = User.builder()
        .name(request.getName())
        .lastname("Empresa") // Default lastname for employers
        .secondLastname("")
        .identityDocument(identityDocument)
        .identityDocumentType(nitDocumentType)
        .birthdate(java.time.LocalDate.of(1990, 1, 1)) // Default birthdate
        .gender(Gender.OTHER) // Default gender
        .build();

    Auth auth = Auth.builder()
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();

    User registeredUser = authServicePort.registerEmployer(auth, user);

    // If an edit code was provided, assign ownership of opportunities with that
    // edit code
    log.debug("--------------------------------------------------------------------------------");
    log.debug("Registering user with edit code {}", request.getEditCode());
    log.debug("--------------------------------------------------------------------------------");
    if (request.getEditCode() != null && !request.getEditCode().isEmpty()) {
      try {
        opportunityFeignAdapter.assignOwnerByEditCode(request.getEditCode(), registeredUser.getId().toString());
      } catch (Exception e) {
        log.debug("Could not assign ownership of opportunities with edit code {}", request.getEditCode(),
            e.getMessage());
      }
    }

    return userRegisteredResponseMapper.toResponse(registeredUser);
  }

  @Override
  public AuthenticatedUserResponse login(AuthenticationRequest request) {
    return authenticatedUserResponseMapper.toResponse(
        authServicePort.login(request.getEmail(), request.getPassword()));
  }

  @Override
  public AuthenticatedUserResponse getAuthenticatedUser() {
    return authenticatedUserResponseMapper.toResponse(
        authServicePort.getAuthenticatedUser());
  }

    @Override
    public AuthResponse getByUserId(UUID userId) {
        return authResponseMapper.toResponse(
            authServicePort.getByUserId(userId));
    }

    @Override
    public void verifyAccount(String email, String token) {
        authServicePort.verifyAccount(email, token);
    }

    @Override
    public void requestPasswordReset(String email) {
        authServicePort.requestPasswordReset(email);
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        authServicePort.resetPassword(token, newPassword);
    }

    @Override
    public void resendVerification(String email) {
        authServicePort.resendVerification(email);
    }
}
