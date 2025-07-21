package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.AuditableNexumEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_user_identity_document", columnList = "identity_document"),
        }
)
public class UserEntity implements NexumEntity<UUID>, AuditableNexumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "identity_document", nullable = false)
    private String identityDocument;

    @Column(name = "id_identity_document_type", nullable = false)
    private Long idIdentityDocumentType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "second_lastname", nullable = false)
    private String secondLastname;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
