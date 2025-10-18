package co.edu.udea.nexum.profile.auth.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthenticationRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.EmployerRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthenticatedUserResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.UserRegisteredResponse;
import co.edu.udea.nexum.profile.auth.application.handler.AuthHandler;
import co.edu.udea.nexum.profile.auth.application.handler.TokenHandler;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.*;
import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;

import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.VERIFY_ACCOUNT_PATH;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.REQUEST_PASSWORD_RESET_PATH;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.RESET_PASSWORD_PATH;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.VERIFY_ACCOUNT_SUMMARY;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.REQUEST_PASSWORD_RESET_SUMMARY;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.RESET_PASSWORD_SUMMARY;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.VERIFY_ACCOUNT_SUCCESSFULLY;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.REQUEST_PASSWORD_RESET_SUCCESSFULLY;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.RESET_PASSWORD_SUCCESSFULLY;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.VERIFY_ACCOUNT_NOT_FOUND;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.REQUEST_PASSWORD_RESET_NOT_FOUND;
import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.RESET_PASSWORD_NOT_FOUND;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH_PATH)
@Tag(name = AUTH_CONTROLLER_NAME, description = AUTH_CONTROLLER_DESCRIPTION)
public class AuthController {
    private final AuthHandler authHandler;
    private final TokenHandler tokenHandler;

    @Operation(summary = SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_REGISTER_ADMINISTRATIVE_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserRegisteredResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CONFLICT,
                    description = SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY_EMAIL_OR_ID_ALREADY_EXISTS,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PostMapping(REGISTER_ADMINISTRATIVE_PATH)
    public ResponseEntity<UserRegisteredResponse> registerAdministrative(@RequestBody @Valid UserRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authHandler.registerAdministrative(request)
        );
    }

    @Operation(summary = SWAGGER_REGISTER_GRADUATE_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_REGISTER_GRADUATE_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserRegisteredResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CONFLICT,
                    description = SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY_EMAIL_OR_ID_ALREADY_EXISTS,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PostMapping(REGISTER_GRADUATE_PATH)
    public ResponseEntity<UserRegisteredResponse> registerGraduate(@RequestBody @Valid UserRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authHandler.registerGraduate(request)
        );
    }

    @Operation(summary = SWAGGER_REGISTER_EMPLOYER_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_REGISTER_EMPLOYER_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserRegisteredResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CONFLICT,
                    description = SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY_EMAIL_OR_ID_ALREADY_EXISTS,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PostMapping(REGISTER_EMPLOYER_PATH)
    public ResponseEntity<UserRegisteredResponse> registerEmployer(@RequestBody @Valid EmployerRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authHandler.registerEmployer(request)
        );
    }

    @Operation(summary = SWAGGER_LOGIN_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_ACCEPTED,
                    description = SWAGGER_LOGIN_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = AuthenticatedUserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CONFLICT,
                    description = SWAGGER_LOGIN_BAD_CREDENTIALS,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PostMapping(LOGIN_PATH)
    public ResponseEntity<AuthenticatedUserResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return ResponseEntity.accepted().body(
                authHandler.login(request)
        );
    }

    @Operation(summary = SWAGGER_VALIDATE_TOKEN_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_VALIDATE_TOKEN_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserRegisteredResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_UNAUTHORIZED,
                    description = SWAGGER_VALIDATE_TOKEN_UNAUTHORIZED,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(VALIDATE_PATH)
    public ResponseEntity<AuthenticatedUserResponse> validateToken(@RequestParam String token) {
        return ResponseEntity.accepted().body(
                tokenHandler.validateToken(token)
        );
    }

    @Operation(summary = SWAGGER_FIND_USER_BY_TOKEN_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_USER_BY_TOKEN_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserRegisteredResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_UNAUTHORIZED,
                    description = SWAGGER_FIND_USER_BY_TOKEN_UNAUTHORIZED,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(GET_USER_BY_TOKEN_PATH)
    public ResponseEntity<UserResponse> getUserByToken(@RequestParam String token) {
        return ResponseEntity.ok(
                tokenHandler.getUserByToken(token)
        );
    }

    @Operation(summary = GET_AUTHENTICATED_USER_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = GET_AUTHENTICATED_USER_SUCCESSFULLY_MESSAGE,
                    content = @Content(schema = @Schema(implementation = UserRegisteredResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_UNAUTHORIZED,
                    description = SWAGGER_FIND_USER_BY_TOKEN_UNAUTHORIZED,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(AUTHENTICATED_USER)
    public ResponseEntity<AuthenticatedUserResponse> getAuthenticatedUser() {
        return ResponseEntity.ok(
                authHandler.getAuthenticatedUser()
        );
    }

    @Operation(summary = GET_AUTH_BY_USER_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = GET_AUTH_BY_USER_ID_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = AuthResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = GET_AUTH_BY_USER_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(GET_AUTH_BY_USER_ID)
    public ResponseEntity<AuthResponse> getAuthByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(
                authHandler.getByUserId(userId)
        );
    }

    @Operation(summary = VERIFY_ACCOUNT_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = VERIFY_ACCOUNT_SUCCESSFULLY
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = VERIFY_ACCOUNT_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(VERIFY_ACCOUNT_PATH)
    public ResponseEntity<Void> verifyAccount(@RequestParam String token) {
        authHandler.verifyAccount(token);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = REQUEST_PASSWORD_RESET_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = REQUEST_PASSWORD_RESET_SUCCESSFULLY
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = REQUEST_PASSWORD_RESET_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @PostMapping(REQUEST_PASSWORD_RESET_PATH)
    public ResponseEntity<Void> requestPasswordReset(@RequestParam String email) {
        authHandler.requestPasswordReset(email);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = RESET_PASSWORD_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = RESET_PASSWORD_SUCCESSFULLY
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = RESET_PASSWORD_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @PostMapping(RESET_PASSWORD_PATH)
    public ResponseEntity<Void> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        authHandler.resetPassword(token, newPassword);
        return ResponseEntity.ok().build();
    }


}
