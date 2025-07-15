package co.edu.udea.nexum.profile.contact_information.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.contact_information.application.dto.request.ContactInformationRequest;
import co.edu.udea.nexum.profile.contact_information.application.dto.response.ContactInformationResponse;
import co.edu.udea.nexum.profile.contact_information.application.handler.ContactInformationHandler;
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

import java.util.UUID;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;
import static co.edu.udea.nexum.profile.contact_information.infrastructure.utils.constants.ContactInformationRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(CONTACT_INFORMATION_CONTROLLER_PATH)
@Tag(name = CONTACT_INFORMATION_CONTROLLER_NAME, description = CONTACT_INFORMATION_CONTROLLER_DESCRIPTION)
public class ContactInformationController {

    private final ContactInformationHandler contactInformationHandler;

    @Operation(summary = SWAGGER_SAVE_CONTACT_INFORMATION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_SAVE_CONTACT_INFORMATION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = ContactInformationResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_FORBIDDEN,
                    description = SWAGGER_SAVE_CONTACT_INFORMATION_FORBIDDEN,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<ContactInformationResponse> save(
            @RequestBody ContactInformationRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contactInformationHandler.save(request));
    }

    @Operation(summary = SWAGGER_FIND_CONTACT_INFORMATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_CONTACT_INFORMATION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = ContactInformationResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_FIND_CONTACT_INFORMATION_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<ContactInformationResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contactInformationHandler.findById(id));
    }

    @Operation(summary = SWAGGER_UPDATE_CONTACT_INFORMATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_UPDATE_CONTACT_INFORMATION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = ContactInformationResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_UPDATE_CONTACT_INFORMATION_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_FORBIDDEN,
                    description = SWAGGER_UPDATE_CONTACT_INFORMATION_FORBIDDEN,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<ContactInformationResponse> updateById(
            @PathVariable Long id,
            @RequestBody ContactInformationRequest request
    ) {
        return ResponseEntity.ok(contactInformationHandler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_BY_USER_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = ContactInformationResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_FORBIDDEN,
                    description = SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_FORBIDDEN,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @GetMapping(CURRENT_BY_USER_ID_PATH)
    public ResponseEntity<ContactInformationResponse> findCurrentByUserId(
            @RequestParam UUID userId
    ) {
        return ResponseEntity.ok(
                contactInformationHandler.findCurrentByUserId(userId)
        );
    }

}
