package co.edu.udea.nexum.profile.family_information.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.family_information.application.dto.request.FamilyInformationRequest;
import co.edu.udea.nexum.profile.family_information.application.dto.response.FamilyInformationResponse;
import co.edu.udea.nexum.profile.family_information.application.handler.FamilyInformationHandler;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;
import static co.edu.udea.nexum.profile.family_information.infrastructure.utils.constants.FamilyInformationRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(FAMILY_INFORMATION_CONTROLLER_PATH)
@Tag(name = FAMILY_INFORMATION_CONTROLLER_NAME, description = FAMILY_INFORMATION_CONTROLLER_DESCRIPTION)
public class FamilyInformationController {

    private final FamilyInformationHandler familyInformationHandler;

    @Operation(summary = SWAGGER_SAVE_FAMILY_INFORMATION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_SAVE_FAMILY_INFORMATION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_FORBIDDEN,
                    description = SWAGGER_SAVE_FAMILY_INFORMATION_FORBIDDEN,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<FamilyInformationResponse> save(
            @RequestBody FamilyInformationRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(familyInformationHandler.save(request));
    }

    @Operation(summary = SWAGGER_FIND_FAMILY_INFORMATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_FAMILY_INFORMATION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = FamilyInformationResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_FIND_FAMILY_INFORMATION_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<FamilyInformationResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(familyInformationHandler.findById(id));
    }

    @Operation(summary = SWAGGER_UPDATE_FAMILY_INFORMATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_UPDATE_FAMILY_INFORMATION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = FamilyInformationResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_UPDATE_FAMILY_INFORMATION_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_FORBIDDEN,
                    description = SWAGGER_UPDATE_FAMILY_INFORMATION_FORBIDDEN,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<FamilyInformationResponse> updateById(
            @PathVariable Long id,
            @RequestBody FamilyInformationRequest request
    ) {
        return ResponseEntity.ok(familyInformationHandler.updateById(id, request));
    }
}
