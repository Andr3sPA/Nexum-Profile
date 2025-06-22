package co.edu.udea.nexum.profile.program_opinion.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.program_opinion.application.dto.request.ProgramOpinionRequest;
import co.edu.udea.nexum.profile.program_opinion.application.dto.response.ProgramOpinionResponse;
import co.edu.udea.nexum.profile.program_opinion.application.handler.ProgramOpinionHandler;
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
import static co.edu.udea.nexum.profile.program_opinion.infrastructure.utils.constants.ProgramOpinionRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(PROGRAM_OPINION_CONTROLLER_PATH)
@Tag(name =PROGRAM_OPINION_CONTROLLER_NAME, description =PROGRAM_OPINION_CONTROLLER_DESCRIPTION)
public class ProgramOpinionController {
    private final ProgramOpinionHandler programOpinionHandler;

    @Operation(summary = SWAGGER_SAVE_PROGRAM_OPINION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_CREATED,
                    description = SWAGGER_SAVE_PROGRAM_OPINION_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_SAVE_PROGRAM_OPINION_CAREER_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_FORBIDDEN,
                    description = SWAGGER_SAVE_PROGRAM_OPINION_CAREER_DOESNT_BELONG_TO_USER,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @PostMapping
    public ResponseEntity<ProgramOpinionResponse> save(
            @RequestBody ProgramOpinionRequest programOpinionRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                programOpinionHandler.save(programOpinionRequest)
        );
    }

    @Operation(summary = SWAGGER_FIND_PROGRAM_OPINION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_FIND_PROGRAM_OPINION_BY_ID_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_FIND_PROGRAM_OPINION_BY_ID_OPINION_DOESNT_EXISTS,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<ProgramOpinionResponse> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                programOpinionHandler.findById(id)
        );
    }


    @Operation(summary = SWAGGER_UPDATE_PROGRAM_OPINION_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_UPDATE_PROGRAM_OPINION_BY_ID_SUCCESSFULLY,
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_FIND_PROGRAM_OPINION_BY_ID_OPINION_DOESNT_EXISTS,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_FORBIDDEN,
                    description = SWAGGER_UPDATE_PROGRAM_OPINION_BY_ID_OPINION_DOESNT_BELONG_TO_USER,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
    })
    @PutMapping(COMMON_ID_PATH)
    public ResponseEntity<ProgramOpinionResponse> updateById(
            @PathVariable Long id,
            @RequestBody ProgramOpinionRequest programOpinionRequest
    ){
        return ResponseEntity.ok(
                programOpinionHandler.updateById(id, programOpinionRequest)
        );
    }
}
