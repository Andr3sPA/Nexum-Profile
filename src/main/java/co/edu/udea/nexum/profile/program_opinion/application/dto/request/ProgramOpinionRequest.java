package co.edu.udea.nexum.profile.program_opinion.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

import static co.edu.udea.nexum.profile.program_opinion.application.util.constants.ProgramOpinionAppConstants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramOpinionRequest implements BaseRequest {
    @NotNull(message = COURSED_PROGRAM_ID_NOT_NULL_MESSAGE)
    private Long coursedProgramId;

    @NotBlank(message = STRENGTHS_NOT_BLANK_MESSAGE)
    private String strengths;

    @NotBlank(message = WEAKNESSES_NOT_BLANK_MESSAGE)
    private String weaknesses;

    @NotEmpty(message = SUGGESTED_COMPETENCIES_NOT_EMPTY_MESSAGE)
    private List<@NotBlank(message = SUGGESTED_COMPETENCY_NOT_BLANK_MESSAGE) String> suggestedCompetencies;

    private boolean whatsappGroupMember;
}