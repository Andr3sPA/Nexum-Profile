package co.edu.udea.nexum.profile.auth.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.filter.AuthFilterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthResponse;
import co.edu.udea.nexum.profile.auth.application.handler.AuthCrudHandler;
import co.edu.udea.nexum.profile.common.application.dto.request.PageQuery;
import co.edu.udea.nexum.profile.common.application.dto.request.PaginationRequest;
import co.edu.udea.nexum.profile.common.application.dto.response.PageResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static co.edu.udea.nexum.profile.auth.infrastructure.utils.constants.AuthRestConstants.*;
import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(ACCOUNT_CONTROLLER_PATH)
@Tag(name = ACCOUNT_CONTROLLER_NAME, description = ACCOUNT_CONTROLLER_DESCRIPTION)
public class AccountController {

    private final AuthCrudHandler authCrudHandler;

    @Operation(summary = SWAGGER_FIND_AUTH_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_AUTH_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_FIND_AUTH_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMINISTRATIVE')")
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<AuthResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(authCrudHandler.findById(id));
    }

    @Operation(summary = SWAGGER_UPDATE_AUTH_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_UPDATE_AUTH_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_UPDATE_AUTH_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_FORBIDDEN, description = SWAGGER_UPDATE_AUTH_FORBIDDEN,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMINISTRATIVE')")
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<AuthResponse> updateById(@PathVariable UUID id, @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authCrudHandler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_FIND_ALL_AUTH_FILTERED_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_ALL_AUTH_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = PageResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMINISTRATIVE')")
    @GetMapping
    public ResponseEntity<PageResponse<AuthResponse>> findAllFiltered(AuthFilterRequest filterRequest, PageQuery query) {
        PaginationRequest pagination = PaginationRequest.build(query);
        return ResponseEntity.ok(authCrudHandler.findAll(filterRequest, pagination));
    }
}
