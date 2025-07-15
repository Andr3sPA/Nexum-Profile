package co.edu.udea.nexum.profile.user.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.configuration.advisor.dto.ExceptionResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.DetailedUserResponse;
import co.edu.udea.nexum.profile.user.application.handler.DetailedUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.*;
import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.SWAGGER_CODE_NOT_FOUND;
import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.SWAGGER_CODE_OK;
import static co.edu.udea.nexum.profile.user.infrastructure.utils.constants.DetailedUserRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = DETAILED_USER_CONTROLLER_PATH)
@Tag(name = DETAILED_USER_CONTROLLER_NAME, description = DETAILED_USER_CONTROLLER_DESCRIPTION)
public class DetailedUserController {

    private final DetailedUserHandler detailedUserHandler;

    @Operation(summary = SWAGGER_FIND_DETAILED_USER_BY_ID_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = SWAGGER_CODE_OK,
                    description = SWAGGER_DETAILED_USER_FOUND,
                    content = @Content(schema = @Schema(implementation = DetailedUserResponse.class))
            ),
            @ApiResponse(
                    responseCode = SWAGGER_CODE_NOT_FOUND,
                    description = SWAGGER_DETAILED_USER_WITH_ID_NOT_FOUND,
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @GetMapping(COMMON_ID_PATH)
    public ResponseEntity<DetailedUserResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(detailedUserHandler.findById(id));
    }

    @GetMapping("/authenticated")
    public ResponseEntity<DetailedUserResponse> getAuthenticated() {
        return ResponseEntity.ok(detailedUserHandler.findAuthenticated());
    }
}
