package co.edu.udea.nexum.profile.user.domain.model.filter;

import co.edu.udea.nexum.profile.academic_education.domain.utils.enums.StudyType;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Generated
@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserFilter {

    private String identityDocument;
    private Long identityDocumentTypeId;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private Gender gender;
    private LocalDate birthdate;

    // Job
    private String companyName;
    private String jobCountry;
    private String position;
    private Boolean relatedToProgram;
    private Long salaryRangeId;
    private Long jobDelayId;
    private Long jobAreaId;
    private Long institutionTypeId;

    // Innovation Process
    private Long innovationTypeId;
    private String innovationName;

    // Coursed Program
    private Integer startYear;
    private Integer endYear;
    private Long[] programIds;

    // Contact
    private String address;
    private String country;
    private String state;
    private String city;
    private String mobile;
    private String email;
    private String academicEmail;
    private Boolean whatsappAuthorization;

    // Auth
    private RoleName role;

    // Academic Education
    private StudyType studyType;
    private String studyName;
    private String academicInstitution;
    private String academicCountry;
    private List<String> complementaryStudies;

    // Graduate Participation
    private Boolean willingToBeSpeaker;
    private Boolean willingToBeProfessor;
    private Boolean willingToTeachNonFormalEducation;
    private Boolean willingToBePostgraduateStudent;
    private Boolean willingToBeNonFormalStudent;
    private Boolean willingToBeGraduateRepresentative;
    private Boolean willingToAttendAlumniMeetings;
    private Boolean willingToParticipateInAlumniActivities;

    private List<Long> programVersionIds;

    @Generated
    private UserFilter(UserFilterBuilder builder) {
        this.identityDocument = builder.identityDocument;
        this.identityDocumentTypeId = builder.identityDocumentTypeId;
        this.name = builder.name;
        this.middleName = builder.middleName;
        this.lastname = builder.lastname;
        this.secondLastname = builder.secondLastname;
        this.gender = builder.gender;
        this.birthdate = builder.birthdate;

        this.companyName = builder.companyName;
        this.jobCountry = builder.jobCountry;
        this.position = builder.position;
        this.relatedToProgram = builder.relatedToProgram;
        this.salaryRangeId = builder.salaryRangeId;
        this.jobDelayId = builder.jobDelayId;
        this.jobAreaId = builder.jobAreaId;
        this.institutionTypeId = builder.institutionTypeId;

        this.innovationTypeId = builder.innovationTypeId;
        this.innovationName = builder.innovationName;

        this.startYear = builder.startYear;
        this.endYear = builder.endYear;
        this.programIds = builder.programIds;

        this.address = builder.address;
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
        this.mobile = builder.mobile;
        this.email = builder.email;
        this.academicEmail = builder.academicEmail;
        this.whatsappAuthorization = builder.whatsappAuthorization;

        this.role = builder.role;

        this.studyType = builder.studyType;
        this.studyName = builder.studyName;
        this.academicInstitution = builder.academicInstitution;
        this.academicCountry = builder.academicCountry;
        this.complementaryStudies = builder.complementaryStudies;
        this.willingToBeSpeaker = builder.willingToBeSpeaker;
        this.willingToBeProfessor = builder.willingToBeProfessor;
        this.willingToTeachNonFormalEducation = builder.willingToTeachNonFormalEducation;
        this.willingToBePostgraduateStudent = builder.willingToBePostgraduateStudent;
        this.willingToBeNonFormalStudent = builder.willingToBeNonFormalStudent;
        this.willingToBeGraduateRepresentative = builder.willingToBeGraduateRepresentative;
        this.willingToAttendAlumniMeetings = builder.willingToAttendAlumniMeetings;
        this.willingToParticipateInAlumniActivities = builder.willingToParticipateInAlumniActivities;
        this.programVersionIds = builder.programVersionIds;
    }

    public static UserFilterBuilder builder() {
        return new UserFilterBuilder();
    }

}
