package co.edu.udea.nexum.profile.user.application.dto.request.filter;

import co.edu.udea.nexum.profile.academic_education.domain.utils.enums.StudyType;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserFilterRequest {

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
}
