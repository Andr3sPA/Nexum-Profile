package co.edu.udea.nexum.profile.user.domain.model.full;

import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.AuditableNexumEntity;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.entity.NexumEntity;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.job.domain.model.Job;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class FullUser implements NexumEntity<UUID>, AuditableNexumEntity {
    private UUID id;
    private String identityDocument;
    private Long idIdentityDocumentType;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private Gender gender;
    private LocalDate birthdate;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private List<Job> jobs;
    private List<CoursedProgram> coursedPrograms;
    private List<ContactInformation> contactInformationList;
    private List<AcademicEducation> academicEducationList;
    private List<InnovationProcess> innovationProcesses;
    private Auth auth;
}
