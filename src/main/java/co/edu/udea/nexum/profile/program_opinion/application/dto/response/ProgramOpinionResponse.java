package co.edu.udea.nexum.profile.program_opinion.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProgramOpinionResponse implements BaseResponse {
    private Long id;
    private Long coursedProgramId;
    private String strengths;
    private String weaknesses;
    private List<String> suggestedCompetencies;
    private boolean whatsappGroupMember;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
