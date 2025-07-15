package co.edu.udea.nexum.profile.user.domain.usecase;

import co.edu.udea.nexum.profile.academic_education.domain.spi.AcademicEducationPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.contact_information.domain.spi.ContactInformationPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.family_information.domain.spi.FamilyInformationPersistencePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;
import co.edu.udea.nexum.profile.graduate_participation.domain.spi.GraduateParticipationPersistencePort;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessPersistencePort;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessTypePersistencePort;
import co.edu.udea.nexum.profile.job.domain.model.Job;
import co.edu.udea.nexum.profile.job.domain.spi.*;
import co.edu.udea.nexum.profile.user.domain.api.DetailedUserServicePort;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.aggregate.DetailedUser;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.domain.utils.functions.DetailedUserMapper;

import java.util.List;
import java.util.UUID;

public class DetailedUserServiceImpl implements DetailedUserServicePort {

    private final UserPersistencePort userPersistencePort;
    private final JobPersistencePort jobPersistencePort;
    private final ContactInformationPersistencePort contactInformationPersistencePort;
    private final FamilyInformationPersistencePort familyInformationPersistencePort;
    private final GraduateParticipationPersistencePort graduateParticipationPersistencePort;
    private final CoursedProgramPersistencePort coursedProgramPersistencePort;
    private final AcademicEducationPersistencePort academicEducationPersistencePort;
    private final SalaryRangePersistencePort salaryRangeServicePort;
    private final JobDelayPersistencePort jobDelayServicePort;
    private final JobAreaPersistencePort jobAreaServicePort;
    private final JobInstitutionTypePersistencePort jobInstitutionTypeServicePort;
    private final InnovationProcessPersistencePort innovationProcessPersistencePort;
    private final InnovationProcessTypePersistencePort innovationProcessTypePersistencePort;
    private final ProgramVersionPersistencePort programVersionServicePort;
    private final IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;
    private final AuthenticationSecurityPort authenticationSecurityPort;
    private final AuthPersistencePort authPersistencePort;

    private DetailedUserServiceImpl(DetailedUserServiceImplBuilder builder) {
        this.userPersistencePort = builder.userPersistencePort;
        this.jobPersistencePort = builder.jobPersistencePort;
        this.contactInformationPersistencePort = builder.contactInformationPersistencePort;
        this.familyInformationPersistencePort = builder.familyInformationPersistencePort;
        this.graduateParticipationPersistencePort = builder.graduateParticipationPersistencePort;
        this.coursedProgramPersistencePort = builder.coursedProgramPersistencePort;
        this.academicEducationPersistencePort = builder.academicEducationPersistencePort;
        this.salaryRangeServicePort = builder.salaryRangePersistencePort;
        this.jobDelayServicePort = builder.jobDelayPersistencePort;
        this.jobAreaServicePort = builder.jobAreaPersistencePort;
        this.jobInstitutionTypeServicePort = builder.jobInstitutionTypePersistencePort;
        this.innovationProcessTypePersistencePort = builder.innovationProcessTypePersistencePort1;
        this.programVersionServicePort = builder.programVersionPersistencePort;
        this.identityDocumentTypePersistencePort = builder.identityDocumentTypePersistencePort;
        this.authenticationSecurityPort = builder.authenticationSecurityPort;
        this.authPersistencePort = builder.authPersistencePort;
        this.innovationProcessPersistencePort = builder.innovationProcessPersistencePort;
    }

    @Override
    public DetailedUser findById(UUID id) {
        User user = loadUserWithDocumentType(id);
        List<Job> jobs = loadDetailedJobs(id);
        List<CoursedProgram> coursedPrograms = loadDetailedCoursedPrograms(id);
        GraduateParticipation graduateParticipation = loadDetailedGraduateParticipation(id);
        List<InnovationProcess> innovationProcesses = loadDetailedInnovationProcesses(id);

        return DetailedUserMapper.toDetailedUser(
                user,
                contactInformationPersistencePort.findCurrentByUserId(id),
                familyInformationPersistencePort.findLastByUserId(id),
                graduateParticipation,
                jobs,
                coursedPrograms,
                academicEducationPersistencePort.findAllByUserId(id),
                innovationProcesses
        );
    }

    private List<InnovationProcess> loadDetailedInnovationProcesses(UUID id) {
        return innovationProcessPersistencePort.findByUserId(id).stream()
                .map(this::getInnovationProcess).toList();
    }

    private InnovationProcess getInnovationProcess(InnovationProcess innovationProcess) {
        InnovationProcessType type = innovationProcessTypePersistencePort.findById(innovationProcess.getType().getId());
        return InnovationProcess.builder()
                .id(innovationProcess.getId())
                .user(innovationProcess.getUser())
                .name(innovationProcess.getName())
                .description(innovationProcess.getDescription())
                .link(innovationProcess.getLink())
                .type(type)
                .creationDate(innovationProcess.getCreationDate())
                .lastUpdate(innovationProcess.getLastUpdate())
                .build();
    }

    @Override
    public DetailedUser findAuthenticated() {
        AuthenticatedUser authenticatedUser = authenticationSecurityPort.getAuthenticatedUser();
        Auth auth = authPersistencePort.findById(authenticatedUser.getId());
        return findById(auth.getUser().getId());
    }

    private User loadUserWithDocumentType(UUID id) {
        User user = userPersistencePort.findById(id);
        if (user == null) throw new EntityNotFoundException(User.class.getSimpleName());

        user.setIdentityDocumentType(
                identityDocumentTypePersistencePort.findById(user.getIdentityDocumentType().getId())
        );
        return user;
    }

    private List<Job> loadDetailedJobs(UUID userId) {
        return jobPersistencePort.findByUserId(userId).stream().map(this::getBuiltJob).toList();
    }

    private Job getBuiltJob(Job job) {
        return Job.builder()
                .id(job.getId())
                .user(job.getUser())
                .position(job.getPosition())
                .salaryRange(job.getSalaryRange() != null
                        ? salaryRangeServicePort.findById(job.getSalaryRange().getId())
                        : null)
                .jobDelay(job.getJobDelay() != null
                        ? jobDelayServicePort.findById(job.getJobDelay().getId())
                        : null)
                .jobArea(job.getJobArea() != null
                        ? jobAreaServicePort.findById(job.getJobArea().getId())
                        : null)
                .institutionType(job.getInstitutionType() != null
                        ? jobInstitutionTypeServicePort.findById(job.getInstitutionType().getId())
                        : null)
                .build();
    }

    private List<CoursedProgram> loadDetailedCoursedPrograms(UUID userId) {
        return coursedProgramPersistencePort.findAllByUserId(userId).stream()
                .map(cp -> {
                    ProgramVersion enrichedVersion = cp.getProgramVersion() != null
                            ? programVersionServicePort.findById(cp.getProgramVersion().getId())
                            : null;

                    return CoursedProgram.builder()
                            .id(cp.getId())
                            .user(cp.getUser())
                            .programVersion(enrichedVersion)
                            .graduationYear(cp.getGraduationYear())
                            .strengths(cp.getStrengths())
                            .weaknesses(cp.getWeaknesses())
                            .improvementSuggestions(cp.getImprovementSuggestions())
                            .creationDate(cp.getCreationDate())
                            .lastUpdate(cp.getLastUpdate())
                            .build();
                })
                .toList();
    }

    private GraduateParticipation loadDetailedGraduateParticipation(UUID userId) {
        return graduateParticipationPersistencePort.findByUserIdOrderByDateDesc(userId).stream()
                .findFirst()
                .orElse(null);
    }


    public static DetailedUserServiceImplBuilder builder() {
        return new DetailedUserServiceImplBuilder();
    }

    public static class DetailedUserServiceImplBuilder {
        private UserPersistencePort userPersistencePort;
        private JobPersistencePort jobPersistencePort;
        private ContactInformationPersistencePort contactInformationPersistencePort;
        private FamilyInformationPersistencePort familyInformationPersistencePort;
        private GraduateParticipationPersistencePort graduateParticipationPersistencePort;
        private CoursedProgramPersistencePort coursedProgramPersistencePort;
        private AcademicEducationPersistencePort academicEducationPersistencePort;
        private SalaryRangePersistencePort salaryRangePersistencePort;
        private JobDelayPersistencePort jobDelayPersistencePort;
        private JobAreaPersistencePort jobAreaPersistencePort;
        private JobInstitutionTypePersistencePort jobInstitutionTypePersistencePort;
        private InnovationProcessPersistencePort innovationProcessPersistencePort;
        private InnovationProcessTypePersistencePort innovationProcessTypePersistencePort1;
        private ProgramVersionPersistencePort programVersionPersistencePort;
        private IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;
        private AuthenticationSecurityPort authenticationSecurityPort;
        private AuthPersistencePort authPersistencePort;

        public DetailedUserServiceImplBuilder userPersistencePort(UserPersistencePort port) {
            this.userPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder jobPersistencePort(JobPersistencePort port) {
            this.jobPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder contactInformationPersistencePort(ContactInformationPersistencePort port) {
            this.contactInformationPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder familyInformationPersistencePort(FamilyInformationPersistencePort port) {
            this.familyInformationPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder graduateParticipationPersistencePort(GraduateParticipationPersistencePort port) {
            this.graduateParticipationPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder coursedProgramPersistencePort(CoursedProgramPersistencePort port) {
            this.coursedProgramPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder academicEducationPersistencePort(AcademicEducationPersistencePort port) {
            this.academicEducationPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder salaryRangePersistencePort(SalaryRangePersistencePort port) {
            this.salaryRangePersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder jobDelayPersistencePort(JobDelayPersistencePort port) {
            this.jobDelayPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder jobAreaPersistencePort(JobAreaPersistencePort port) {
            this.jobAreaPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder jobInstitutionTypePersistencePort(JobInstitutionTypePersistencePort port) {
            this.jobInstitutionTypePersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder innovationProcessTypePersistencePort(InnovationProcessTypePersistencePort port) {
            this.innovationProcessTypePersistencePort1 = port;
            return this;
        }

        public DetailedUserServiceImplBuilder programVersionPersistencePort(ProgramVersionPersistencePort port) {
            this.programVersionPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder identityDocumentTypePersistencePort(IdentityDocumentTypePersistencePort port) {
            this.identityDocumentTypePersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder authenticationSecurityPort(AuthenticationSecurityPort port) {
            this.authenticationSecurityPort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder authPersistencePort(AuthPersistencePort port) {
            this.authPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImplBuilder innovationProcessPersistencePort(InnovationProcessPersistencePort port) {
            this.innovationProcessPersistencePort = port;
            return this;
        }

        public DetailedUserServiceImpl build() {
            return new DetailedUserServiceImpl(this);
        }
    }
}
