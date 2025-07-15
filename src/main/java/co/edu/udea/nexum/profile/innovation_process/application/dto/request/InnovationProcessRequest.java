package co.edu.udea.nexum.profile.innovation_process.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static co.edu.udea.nexum.profile.innovation_process.application.utils.constants.InnovationProcessAppConstants.*;

@Data
@Builder
public class InnovationProcessRequest implements BaseRequest {

    @NotNull(message = USER_ID_NOT_NULL_MESSAGE)
    private UUID userId;

    @NotNull(message = TYPE_ID_NOT_NULL_MESSAGE)
    private Long typeId;

    @NotBlank(message = NAME_NOT_BLANK_MESSAGE)
    private String name;

    private String description;

    private String link;
}
