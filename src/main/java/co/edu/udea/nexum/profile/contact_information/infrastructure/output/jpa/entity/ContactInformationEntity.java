package co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.entity;

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
    name = "contact_information",
    indexes = {
        @Index(name = "idx_contact_information_user_id", columnList = "user_id"),
        @Index(name = "idx_contact_information_email", columnList = "email"),
        @Index(name = "idx_contact_information_academic_email", columnList = "academic_email")
    }
)
public class ContactInformationEntity implements NexumEntity<Long>, AuditableNexumEntity {

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
    @Column(name = "contact_information_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "landline")
    private String landline;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "academic_email", unique = true)
    private String academicEmail;

    @Column(name = "whatsapp_group_authorized", nullable = false)
    private boolean whatsappAuthorization;

    @Column(name = "is_current", nullable = false)
    private Boolean current;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
