package co.edu.udea.nexum.profile.user.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.application.dto.request.PageQuery;
import co.edu.udea.nexum.profile.common.application.dto.request.PaginationRequest;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.application.dto.request.filter.UserFilterRequest;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.basic.BasicUserResponse;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = USER_CONTROLLER_PATH)
@Tag(name = USER_CONTROLLER_NAME, description = USER_CONTROLLER_DESCRIPTION)
public class UserController {
    private final UserHandler userHandler;

    @Operation(summary = SWAGGER_SAVE_USER_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_USER_SAVED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMINISTRATIVE')")
    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest request) {
        return ResponseEntity.ok(userHandler.save(request));
    }

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

    @GetMapping(AUTHENTICATED)
    public ResponseEntity<UserResponse> findCurrentUser() {
        return ResponseEntity.ok(userHandler.findAuthenticatedUser());
    }

    @Operation(summary = SWAGGER_FIND_ALL_USERS_FILTERED_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_ALL_USERS_FILTERED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = BasicUserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PreAuthorize("hasAnyRole('DEAN', 'ADMINISTRATIVE','EMPLOYER')")
    @GetMapping(USER_CONTROLLER_FILTER_PATH)
    public ResponseEntity<?> findAllFiltered(
            UserFilterRequest filterRequest,
            PageQuery query
    ) {
        PaginationRequest paginationRequest = PaginationRequest.build(query);
        return ResponseEntity.ok(userHandler.findAllFiltered(filterRequest, paginationRequest));
    }

    @Operation(summary = "Get authenticated user's basic profile")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = "Authenticated user basic profile found",
                    content = @Content(schema = @Schema(implementation = BasicUserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = "Authenticated user not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping("/me/basic")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BasicUserResponse> getAuthenticatedUserBasic() {
        return ResponseEntity.ok(userHandler.findAuthenticatedUserBasic());
    }
    
    @Operation(summary = "Get user basic profile by auth ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = "User basic profile found",
                    content = @Content(schema = @Schema(implementation = BasicUserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = "User not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping("/basic")
    public ResponseEntity<BasicUserResponse> getUserBasicByAuthId(@RequestParam UUID authId) {
        return ResponseEntity.ok(userHandler.findUserBasicByAuthId(authId));
    }
}
