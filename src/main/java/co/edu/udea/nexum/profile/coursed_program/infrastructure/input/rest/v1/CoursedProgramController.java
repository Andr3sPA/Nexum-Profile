package co.edu.udea.nexum.profile.coursed_program.infrastructure.input.rest.v1;


import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.input.rest.BaseCrudController;
import co.edu.udea.nexum.profile.coursed_program.application.dto.request.CoursedProgramRequest;
import co.edu.udea.nexum.profile.coursed_program.application.dto.response.CoursedProgramResponse;
import co.edu.udea.nexum.profile.coursed_program.application.handler.CoursedProgramHandler;
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

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;
import static co.edu.udea.nexum.profile.coursed_program.infrastructure.utils.constants.CoursedProgramRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = COURSED_PROGRAM_CONTROLLER_PATH)
@Tag(name = COURSED_PROGRAM_CONTROLLER_NAME, description = COURSED_PROGRAM_CONTROLLER_DESCRIPTION)
public class CoursedProgramController implements BaseCrudController<Long, CoursedProgramResponse, CoursedProgramRequest> {
    private final CoursedProgramHandler coursedProgramHandler;

    @Operation(summary = SWAGGER_SAVE_NEW_COURSED_PROGRAM_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_NEW_COURSED_PROGRAM_SAVED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = CoursedProgramResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PostMapping
    public ResponseEntity<CoursedProgramResponse> save(@RequestBody @Valid CoursedProgramRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coursedProgramHandler.save(request));
    }

    @Operation(summary = SWAGGER_FIND_COURSED_PROGRAM_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_COURSED_PROGRAM_FOUND,
                    content = @Content(schema = @Schema(implementation = CoursedProgramResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_COURSED_PROGRAM_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<CoursedProgramResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(coursedProgramHandler.findById(id));
    }

    @Operation(summary = SWAGGER_FIND_ALL_COURSED_PROGRAMS_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_ALL_COURSED_PROGRAMS_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CoursedProgramResponse.class)))
            ),
    })
    @GetMapping
    public ResponseEntity<List<CoursedProgramResponse>> findAll() {
        return ResponseEntity.ok(coursedProgramHandler.findAll());
    }

    @Operation(summary = SWAGGER_UPDATE_COURSED_PROGRAM_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_COURSED_PROGRAM_UPDATED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = CoursedProgramResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_COURSED_PROGRAM_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_BAD_REQUEST,
                    description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))
            ),
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<CoursedProgramResponse> updateById(@PathVariable Long id, @RequestBody @Valid CoursedProgramRequest request) {
        return ResponseEntity.ok(coursedProgramHandler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_DELETE_COURSED_PROGRAM_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_COURSED_PROGRAM_DELETED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = CoursedProgramResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_COURSED_PROGRAM_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @DeleteMapping(COMMON_ID_PATH)
    public ResponseEntity<CoursedProgramResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(coursedProgramHandler.deleteById(id));
    }
}
