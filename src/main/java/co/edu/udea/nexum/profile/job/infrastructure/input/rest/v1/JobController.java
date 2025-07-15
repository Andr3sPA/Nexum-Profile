package co.edu.udea.nexum.profile.job.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.input.rest.BaseCrudController;
import co.edu.udea.nexum.profile.job.application.dto.request.JobRequest;
import co.edu.udea.nexum.profile.job.application.dto.response.JobResponse;
import co.edu.udea.nexum.profile.job.application.handler.JobHandler;
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
import static co.edu.udea.nexum.profile.job.infrastructure.utils.constants.JobRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = JOB_CONTROLLER_PATH)
@Tag(name = JOB_CONTROLLER_NAME, description = JOB_CONTROLLER_DESCRIPTION)
public class JobController implements BaseCrudController<Long, JobResponse, JobRequest> {

    private final JobHandler jobHandler;

    @Operation(summary = SWAGGER_SAVE_NEW_JOB_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_CREATED, description = SWAGGER_NEW_JOB_SAVED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = JobResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PostMapping
    public ResponseEntity<JobResponse> save(@RequestBody @Valid JobRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobHandler.save(request));
    }

    @Operation(summary = SWAGGER_FIND_JOB_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_JOB_FOUND,
                    content = @Content(schema = @Schema(implementation = JobResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_JOB_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<JobResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(jobHandler.findById(id));
    }

    @Operation(summary = SWAGGER_FIND_ALL_JOBS_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_ALL_JOBS_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = JobResponse.class))))
    })
    @GetMapping
    public ResponseEntity<List<JobResponse>> findAll() {
        return ResponseEntity.ok(jobHandler.findAll());
    }

    @Operation(summary = SWAGGER_UPDATE_JOB_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_JOB_UPDATED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = JobResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_JOB_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<JobResponse> updateById(@PathVariable Long id, @RequestBody @Valid JobRequest request) {
        return ResponseEntity.ok(jobHandler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_DELETE_JOB_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_JOB_DELETED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = JobResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_JOB_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @DeleteMapping(COMMON_ID_PATH)
    public ResponseEntity<JobResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(jobHandler.deleteById(id));
    }

    @Operation(summary = SWAGGER_FIND_JOB_BY_USER_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_JOB_BY_USER_ID_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = JobResponse.class))))
    })
    @GetMapping(USER_PATH)
    public ResponseEntity<List<JobResponse>> findByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(jobHandler.findByUserId(userId));
    }
}
