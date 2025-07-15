package co.edu.udea.nexum.profile.graduate_participation.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.input.rest.BaseCrudController;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.request.GraduateParticipationRequest;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.response.GraduateParticipationResponse;
import co.edu.udea.nexum.profile.graduate_participation.application.handler.GraduateParticipationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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

import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;
import static co.edu.udea.nexum.profile.graduate_participation.infrastructure.utils.constants.GraduateParticipationRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = GRADUATE_PARTICIPATION_CONTROLLER_PATH)
@Tag(name = GRADUATE_PARTICIPATION_CONTROLLER_NAME, description = GRADUATE_PARTICIPATION_CONTROLLER_DESCRIPTION)
public class GraduateParticipationController implements BaseCrudController<Long, GraduateParticipationResponse, GraduateParticipationRequest> {

    private final GraduateParticipationHandler handler;

    @Operation(summary = SWAGGER_SAVE_NEW_GRADUATE_PARTICIPATION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_CREATED, description = SWAGGER_NEW_GRADUATE_PARTICIPATION_SAVED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = GraduateParticipationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PostMapping
    public ResponseEntity<GraduateParticipationResponse> save(@RequestBody @Valid GraduateParticipationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(handler.save(request));
    }

    @Operation(summary = SWAGGER_FIND_GRADUATE_PARTICIPATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_GRADUATE_PARTICIPATION_FOUND,
                    content = @Content(schema = @Schema(implementation = GraduateParticipationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_GRADUATE_PARTICIPATION_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<GraduateParticipationResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(handler.findById(id));
    }

    @Operation(summary = SWAGGER_FIND_ALL_GRADUATE_PARTICIPATION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_ALL_GRADUATE_PARTICIPATION_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = GraduateParticipationResponse.class))))
    })
    @GetMapping
    public ResponseEntity<List<GraduateParticipationResponse>> findAll() {
        return ResponseEntity.ok(handler.findAll());
    }

    @Operation(summary = SWAGGER_UPDATE_GRADUATE_PARTICIPATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_GRADUATE_PARTICIPATION_UPDATED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = GraduateParticipationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_GRADUATE_PARTICIPATION_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<GraduateParticipationResponse> updateById(@PathVariable Long id, @RequestBody @Valid GraduateParticipationRequest request) {
        return ResponseEntity.ok(handler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_DELETE_GRADUATE_PARTICIPATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_GRADUATE_PARTICIPATION_DELETED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = GraduateParticipationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_GRADUATE_PARTICIPATION_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @DeleteMapping(COMMON_ID_PATH)
    public ResponseEntity<GraduateParticipationResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(handler.deleteById(id));
    }

    @Operation(summary = SWAGGER_FIND_GRADUATE_PARTICIPATION_BY_USER_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_GRADUATE_PARTICIPATION_BY_USER_ID_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = GraduateParticipationResponse.class))))
    })
    @GetMapping(USER_PATH)
    public ResponseEntity<List<GraduateParticipationResponse>> findByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(handler.findByUserId(userId));
    }
}
