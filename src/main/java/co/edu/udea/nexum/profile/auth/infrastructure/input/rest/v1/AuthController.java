package co.edu.udea.nexum.profile.auth.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthenticationRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
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
    
    
}
