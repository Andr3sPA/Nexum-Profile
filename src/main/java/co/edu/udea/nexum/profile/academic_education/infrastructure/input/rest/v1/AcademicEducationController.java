package co.edu.udea.nexum.profile.academic_education.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.academic_education.application.dto.request.AcademicEducationRequest;
import co.edu.udea.nexum.profile.academic_education.application.dto.response.AcademicEducationResponse;
import co.edu.udea.nexum.profile.academic_education.application.handler.AcademicEducationHandler;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ValidationExceptionResponse;
import co.edu.udea.nexum.profile.common.infrastructure.input.rest.BaseCrudController;
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

import static co.edu.udea.nexum.profile.academic_education.infrastructure.utils.constants.AcademicEducationRestConstants.*;
import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ACADEMIC_EDUCATION_CONTROLLER_PATH)
@Tag(name = ACADEMIC_EDUCATION_CONTROLLER_NAME, description = ACADEMIC_EDUCATION_CONTROLLER_DESCRIPTION)
public class AcademicEducationController implements BaseCrudController<Long, AcademicEducationResponse, AcademicEducationRequest> {

    private final AcademicEducationHandler academicEducationHandler;

    @Operation(summary = SWAGGER_SAVE_NEW_ACADEMIC_EDUCATION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_CREATED, description = SWAGGER_NEW_ACADEMIC_EDUCATION_SAVED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = AcademicEducationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PostMapping
    public ResponseEntity<AcademicEducationResponse> save(@RequestBody @Valid AcademicEducationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(academicEducationHandler.save(request));
    }

    @Operation(summary = SWAGGER_FIND_ACADEMIC_EDUCATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_ACADEMIC_EDUCATION_FOUND,
                    content = @Content(schema = @Schema(implementation = AcademicEducationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_ACADEMIC_EDUCATION_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<AcademicEducationResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(academicEducationHandler.findById(id));
    }

    @Operation(summary = SWAGGER_FIND_ALL_ACADEMIC_EDUCATIONS_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_FIND_ALL_ACADEMIC_EDUCATIONS_SUCCESSFULLY,
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = AcademicEducationResponse.class))))
    })
    @GetMapping
    public ResponseEntity<List<AcademicEducationResponse>> findAll() {
        return ResponseEntity.ok(academicEducationHandler.findAll());
    }

    @Operation(summary = SWAGGER_UPDATE_ACADEMIC_EDUCATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_ACADEMIC_EDUCATION_UPDATED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = AcademicEducationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_ACADEMIC_EDUCATION_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_BAD_REQUEST, description = SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS,
                    content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class)))
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<AcademicEducationResponse> updateById(@PathVariable Long id, @RequestBody @Valid AcademicEducationRequest request) {
        return ResponseEntity.ok(academicEducationHandler.updateById(id, request));
    }

    @Operation(summary = SWAGGER_DELETE_ACADEMIC_EDUCATION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SWAGGER_CODE_OK, description = SWAGGER_ACADEMIC_EDUCATION_DELETED_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = AcademicEducationResponse.class))),
            @ApiResponse(responseCode = SWAGGER_CODE_NOT_FOUND, description = SWAGGER_ACADEMIC_EDUCATION_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @DeleteMapping(COMMON_ID_PATH)
    public ResponseEntity<AcademicEducationResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(academicEducationHandler.deleteById(id));
    }
}
