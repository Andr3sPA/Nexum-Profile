package co.edu.udea.nexum.profile.metrics.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetricsResponse {
    private long totalUsers;
    private Map<String, Long> usersByRole;
    private long totalGraduates;
    private List<ProgramCount> graduatesByProgramVersion;
    private long currentJobsCount;
    private long relatedToProgramJobsCount;
    private long graduateParticipationCount;
    private long innovationProcessCount;
    private long programOpinionCount;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProgramCount {
        private Long programVersionId;
        private Long count;
    }
}
