package co.edu.udea.nexum.profile.family_information.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import co.edu.udea.nexum.profile.family_information.domain.utils.enums.MaritalState;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static co.edu.udea.nexum.profile.coursed_program.application.utils.constants.CoursedProgramConstants.USER_ID_FIELD_NOT_NULL_MESSAGE;
import static co.edu.udea.nexum.profile.family_information.application.utils.constants.FamilyInformationAppConstants.*;

@Data
@Builder
public class FamilyInformationRequest implements BaseRequest {

    @NotNull(message = USER_ID_FIELD_NOT_NULL_MESSAGE)
    private UUID userId;

    @NotNull(message = MARITAL_STATE_FIELD_NOT_NULL_MESSAGE)
    private MaritalState maritalState;

    @NotNull(message = CHILD_NUMBER_FIELD_NOT_NULL_MESSAGE)
    @PositiveOrZero(message = CHILD_NUMBER_FIELD_POSITIVE_MESSAGE)
    private Short childNumber;
}
