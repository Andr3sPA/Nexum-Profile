package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "user_coursed_program",
        indexes = {
                @Index(name = "idx_user_coursed_program_user_id", columnList = "user_id"),
                @Index(name = "idx_user_coursed_program_version_id", columnList = "program_version_id"),
        }
)
public class CoursedProgramEntity implements NexumEntity<Long> {

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_coursed_program_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "graduation_year", nullable = false)
    private Integer graduationYear;

    @Column(name = "program_version_id", nullable = false)
    private Long programVersionId;

    @ElementCollection
    @CollectionTable(
            name = "user_coursed_program_strengths",
            joinColumns = @JoinColumn(name = "user_coursed_program_id")
    )
    @Column(name = "strength")
    private List<String> strengths;

    @ElementCollection
    @CollectionTable(
            name = "user_coursed_program_weaknesses",
            joinColumns = @JoinColumn(name = "user_coursed_program_id")
    )
    @Column(name = "weakness")
    private List<String> weaknesses;

    @ElementCollection
    @CollectionTable(
            name = "user_coursed_program_improvement_suggestions",
            joinColumns = @JoinColumn(name = "user_coursed_program_id")
    )
    @Column(name = "suggestion")
    private List<String> improvementSuggestions;
}

