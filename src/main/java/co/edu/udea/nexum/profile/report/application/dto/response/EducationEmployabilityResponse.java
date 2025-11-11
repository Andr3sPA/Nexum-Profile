package co.edu.udea.nexum.profile.report.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EducationEmployabilityResponse {
    private Long totalGraduates;
    private Long employedGraduates;
    private Double employabilityRate;
    private List<ProgramEmployability> byProgram;
}