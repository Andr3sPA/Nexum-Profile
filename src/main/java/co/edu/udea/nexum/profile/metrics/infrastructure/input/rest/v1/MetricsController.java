package co.edu.udea.nexum.profile.metrics.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository.AuthRepository;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.repository.CoursedProgramRepository;
import co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.repository.GraduateParticipationRepository;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.repository.InnovationProcessRepository;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.repository.JobRepository;
import co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.repository.ProgramOpinionRepository;
import co.edu.udea.nexum.profile.metrics.application.dto.response.MetricsResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/metrics")
@Tag(name = "Metrics", description = "EndPoints to obtain aggregated metrics for admins and deans")
public class MetricsController {

    private final AuthRepository authRepository;
    private final CoursedProgramRepository coursedProgramRepository;
    private final JobRepository jobRepository;
    private final GraduateParticipationRepository graduateParticipationRepository;
    private final InnovationProcessRepository innovationProcessRepository;
    private final ProgramOpinionRepository programOpinionRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ADMINISTRATIVE','DEAN')")
    public ResponseEntity<MetricsResponse> getMetrics() {
        long totalUsers = authRepository.count();

        Map<String, Long> usersByRole = new HashMap<>();
        for (RoleName rn : RoleName.values()) {
            long c = authRepository.countByRole_Name(rn);
            usersByRole.put(rn.name(), c);
        }

        long totalGraduates = usersByRole.getOrDefault(RoleName.GRADUATE.name(), 0L);

        List<Object[]> programCounts = coursedProgramRepository.countByProgramVersion();
        List<MetricsResponse.ProgramCount> programCountList = new ArrayList<>();
        for (Object[] row : programCounts) {
            Long programVersionId = row[0] == null ? null : ((Number) row[0]).longValue();
            Long count = row[1] == null ? 0L : ((Number) row[1]).longValue();
            programCountList.add(MetricsResponse.ProgramCount.builder()
                    .programVersionId(programVersionId)
                    .count(count)
                    .build());
        }

        long currentJobsCount = jobRepository.countByCurrentJobTrue();
        long relatedToProgramJobsCount = jobRepository.countByCurrentJobTrueAndRelatedToProgramTrue();

        long graduateParticipationCount = graduateParticipationRepository.count();
        long innovationProcessCount = innovationProcessRepository.count();
        long programOpinionCount = programOpinionRepository.count();

        MetricsResponse response = MetricsResponse.builder()
                .totalUsers(totalUsers)
                .usersByRole(usersByRole)
                .totalGraduates(totalGraduates)
                .graduatesByProgramVersion(programCountList)
                .currentJobsCount(currentJobsCount)
                .relatedToProgramJobsCount(relatedToProgramJobsCount)
                .graduateParticipationCount(graduateParticipationCount)
                .innovationProcessCount(innovationProcessCount)
                .programOpinionCount(programOpinionCount)
                .build();

        return ResponseEntity.ok(response);
    }
}
