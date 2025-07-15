package co.edu.udea.nexum.profile.job.infrastructure.output.jpa.entity;

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
    name = "job",
    indexes = {
        @Index(name = "idx_job_user_id", columnList = "user_id"),
        @Index(name = "idx_job_company_name", columnList = "company_name"),
        @Index(name = "idx_job_country", columnList = "country")
    }
)
public class JobEntity implements NexumEntity<Long>, AuditableNexumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "related_to_program", nullable = false)
    private Boolean relatedToProgram;

    @Column(name = "salary_range_id")
    private Long salaryRangeId;

    @Column(name = "job_delay_id")
    private Long jobDelayId;

    @Column(name = "job_area_id")
    private Long jobAreaId;

    @Column(name = "institution_type_id")
    private Long institutionTypeId;

    @Column(name = "first_job", nullable = false)
    private Boolean firstJob;

    @Column(name = "current_job", nullable = false)
    private Boolean currentJob;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
