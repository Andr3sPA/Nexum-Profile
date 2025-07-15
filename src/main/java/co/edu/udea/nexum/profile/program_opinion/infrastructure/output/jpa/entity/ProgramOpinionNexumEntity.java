package co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.AuditableNexumEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity.CoursedProgramEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "program_opinion",
        indexes = {
                @Index(name = "idx_program_opinion_coursed_program_id", columnList = "user_coursed_program_id")
        }
)
public class ProgramOpinionNexumEntity implements NexumEntity<Long>, AuditableNexumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_opinion_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_coursed_program_id", referencedColumnName = "user_coursed_program_id", nullable = false)
    private CoursedProgramEntity coursedProgram;

    @Column(name = "strengths", nullable = false)
    private String strengths;

    @Column(name = "weaknesses", nullable = false)
    private String weaknesses;

    @ElementCollection
    @CollectionTable(
            name = "program_opinion_suggested_competency",
            joinColumns = @JoinColumn(name = "program_opinion_id")
    )
    @Column(name = "competency", nullable = false)
    private List<String> suggestedCompetencies;

    @Column(name = "whatsapp_group_member", nullable = false)
    private boolean whatsappGroupMember;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
