package co.edu.udea.nexum.profile.user.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import co.edu.udea.nexum.profile.user.application.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;
import static co.edu.udea.nexum.profile.user.infrastructure.utils.constants.UserRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = USER_CONTROLLER_PATH)
@Tag(name = USER_CONTROLLER_NAME, description = USER_CONTROLLER_DESCRIPTION)
public class UserController {
    private final UserHandler userHandler;

    @Operation(summary = SWAGGER_FIND_USER_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_USER_FOUND,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_USER_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<UserResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userHandler.findById(id));
    }

    @Operation(summary = SWAGGER_FIND_ALL_USERS_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_ALL_USERS_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)))
            ),
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMINISTRATIVE')")
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userHandler.findAll());
    }

    @Operation(summary = SWAGGER_UPDATE_USER_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_USER_UPDATED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_USER_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<UserResponse> updateById(@PathVariable UUID id, @Valid @RequestBody UserRequest request) {
        return ResponseEntity.ok(userHandler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_DELETE_USER_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_USER_DELETED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_USER_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMINISTRATIVE')")
    @DeleteMapping(COMMON_ID_PATH)
    public ResponseEntity<UserResponse> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(userHandler.deleteById(id));
    }
}
