package co.edu.udea.nexum.profile.coursed_program.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.coursed_program.application.utils.constants.CoursedProgramConstants.*;

@Data
@Builder
public class CoursedProgramRequest implements BaseRequest {

    @NotNull(message = USER_ID_FIELD_NOT_NULL_MESSAGE)
    private UUID userId;

    @NotNull(message = PROGRAM_VERSION_ID_FIELD_NOT_NULL_MESSAGE)
    private Long programVersionId;

    @Positive(message = GRADUATION_YEAR_FIELD_POSITIVE_MESSAGE)
    @NotNull(message = GRADUATION_YEAR_FIELD_NOT_NULL_MESSAGE)
    private Integer graduationYear;

    private List<String> strengths;
    private List<String> weaknesses;
    private List<String> improvementSuggestions;
}
