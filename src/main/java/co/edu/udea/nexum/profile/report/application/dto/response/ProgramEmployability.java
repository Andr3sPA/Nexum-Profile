package co.edu.udea.nexum.profile.report.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgramEmployability {
    private String programName;
    private Long totalGraduates;
    private Long employedGraduates;
    private Double employabilityRate;
}