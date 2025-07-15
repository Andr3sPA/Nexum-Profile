package co.edu.udea.nexum.profile.innovation_process.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.input.rest.BaseCrudController;
import co.edu.udea.nexum.profile.innovation_process.application.dto.request.InnovationProcessRequest;
import co.edu.udea.nexum.profile.innovation_process.application.dto.response.InnovationProcessResponse;
import co.edu.udea.nexum.profile.innovation_process.application.handler.InnovationProcessHandler;
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
import static co.edu.udea.nexum.profile.innovation_process.infrastructure.utils.constants.InnovationProcessRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = INNOVATION_PROCESS_CONTROLLER_PATH)
@Tag(name = INNOVATION_PROCESS_CONTROLLER_NAME, description = INNOVATION_PROCESS_CONTROLLER_DESCRIPTION)
public class InnovationProcessController implements BaseCrudController<Long, InnovationProcessResponse, InnovationProcessRequest> {

    private final InnovationProcessHandler handler;

    @Operation(summary = SWAGGER_SAVE_NEW_INNOVATION_PROCESS_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_CREATED, description = SWAGGER_NEW_INNOVATION_PROCESS_SAVED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = InnovationProcessResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PostMapping
    public ResponseEntity<InnovationProcessResponse> save(@RequestBody @Valid InnovationProcessRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(handler.save(request));
    }

    @Operation(summary = SWAGGER_FIND_INNOVATION_PROCESS_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_INNOVATION_PROCESS_FOUND,
                    content = @Content(schema = @Schema(implementation = InnovationProcessResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_INNOVATION_PROCESS_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<InnovationProcessResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(handler.findById(id));
    }

    @Operation(summary = SWAGGER_FIND_ALL_INNOVATION_PROCESSES_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_ALL_INNOVATION_PROCESSES_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = InnovationProcessResponse.class))))
    })
    @GetMapping
    public ResponseEntity<List<InnovationProcessResponse>> findAll() {
        return ResponseEntity.ok(handler.findAll());
    }

    @Operation(summary = SWAGGER_UPDATE_INNOVATION_PROCESS_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_INNOVATION_PROCESS_UPDATED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = InnovationProcessResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_INNOVATION_PROCESS_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<InnovationProcessResponse> updateById(@PathVariable Long id, @RequestBody @Valid InnovationProcessRequest request) {
        return ResponseEntity.ok(handler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_DELETE_INNOVATION_PROCESS_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_INNOVATION_PROCESS_DELETED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = InnovationProcessResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_INNOVATION_PROCESS_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @DeleteMapping(COMMON_ID_PATH)
    public ResponseEntity<InnovationProcessResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(handler.deleteById(id));
    }

    @Operation(summary = SWAGGER_FIND_INNOVATION_PROCESS_BY_USER_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_INNOVATION_PROCESS_BY_USER_ID_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = InnovationProcessResponse.class))))
    })
    @GetMapping(USER_PATH)
    public ResponseEntity<List<InnovationProcessResponse>> findByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(handler.findByUserId(userId));
    }
}
