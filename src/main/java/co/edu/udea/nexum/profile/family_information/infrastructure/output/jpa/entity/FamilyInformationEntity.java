package co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.AuditableNexumEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.family_information.domain.utils.enums.MaritalState;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "family_information",
        indexes = {
                @Index(name = "idx_family_information_user_id", columnList = "user_id")
        }
)
public class FamilyInformationEntity implements NexumEntity<Long>, AuditableNexumEntity {

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
    @Column(name = "family_information_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_state", nullable = false)
    private MaritalState maritalState;

    @Column(name = "child_number", nullable = false)
    private Short childNumber;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
