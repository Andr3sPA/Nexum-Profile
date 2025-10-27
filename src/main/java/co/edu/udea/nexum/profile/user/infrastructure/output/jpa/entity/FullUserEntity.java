package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.entity.AcademicEducationEntity;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.AuditableNexumEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.entity.ContactInformationEntity;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity.CoursedProgramEntity;
import co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.entity.GraduateParticipationEntity;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.entity.InnovationProcessEntity;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.entity.JobEntity;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
public class FullUserEntity implements NexumEntity<UUID>, AuditableNexumEntity {

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<JobEntity> jobs;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CoursedProgramEntity> coursedPrograms;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ContactInformationEntity> contactInformationList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<AcademicEducationEntity> academicEducationList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<InnovationProcessEntity> innovationProcesses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<GraduateParticipationEntity> graduateParticipationList;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private AuthEntity auth;
}
