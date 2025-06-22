package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;


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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_coursed_program_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "program_version_id", nullable = false)
    private Long programVersionId;
}
