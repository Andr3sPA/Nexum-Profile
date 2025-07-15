package co.edu.udea.nexum.profile.user.application.dto.response;

import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DetailedCoursedProgramResponse {
    private Long id;
    private ProgramVersionResponse programVersion;
    private Integer graduationYear;
    private List<String> strengths;
    private List<String> weaknesses;
    private List<String> improvementSuggestions;
}
