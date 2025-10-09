package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.AuditableNexumEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
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
    name = "innovation_process",
    indexes = {
        @Index(name = "idx_innovation_process_user_id", columnList = "user_id"),
        @Index(name = "idx_innovation_process_type_id", columnList = "type_id"),
        @Index(name = "idx_innovation_process_name", columnList = "name")
    }
)
public class InnovationProcessEntity implements NexumEntity<Long>, AuditableNexumEntity {

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
    @Column(name = "innovation_process_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "type_id", nullable = false)
    private Long type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
