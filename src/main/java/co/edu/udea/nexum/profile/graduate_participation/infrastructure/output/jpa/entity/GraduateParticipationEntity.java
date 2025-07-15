package co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.entity;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.AuditableNexumEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
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
    name = "graduate_participation",
    indexes = {
        @Index(name = "idx_graduate_participation_user_id", columnList = "user_id")
    }
)
public class GraduateParticipationEntity implements NexumEntity<Long>, AuditableNexumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "graduate_participation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ElementCollection
    @CollectionTable(name = "graduate_participation_education_interest", joinColumns = @JoinColumn(name = "graduate_participation_id"))
    @Column(name = "education_interest")
    private List<String> continuousEducationInterests;

    @Column(name = "willing_to_be_speaker", nullable = false)
    private boolean willingToBeSpeaker;

    @Column(name = "willing_to_be_professor", nullable = false)
    private boolean willingToBeProfessor;

    @Column(name = "willing_to_teach_non_formal", nullable = false)
    private boolean willingToTeachNonFormalEducation;

    @Column(name = "willing_to_be_postgraduate_student", nullable = false)
    private boolean willingToBePostgraduateStudent;

    @Column(name = "willing_to_be_non_formal_student", nullable = false)
    private boolean willingToBeNonFormalStudent;

    @Column(name = "willing_to_be_representative", nullable = false)
    private boolean willingToBeGraduateRepresentative;

    @Column(name = "willing_to_attend_meetings", nullable = false)
    private boolean willingToAttendAlumniMeetings;

    @Column(name = "willing_to_participate_alumni_activities", nullable = false)
    private boolean willingToParticipateInAlumniActivities;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
