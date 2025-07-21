package co.edu.udea.nexum.profile.user.application.dto.response.detailed;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.IdentityDocumentTypeResponse;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class DetailedUserResponse implements BaseResponse {
    private UUID id;

    private String identityDocument;
    private IdentityDocumentTypeResponse identityDocumentType;

    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;

    private String institutionalEmail;
    private Gender gender;
    private LocalDate birthdate;

    private DetailedContactInformationResponse contactInformation;
    private DetailedFamilyInformationResponse familyInformation;
    private DetailedGraduateParticipationResponse graduateParticipation;

    private List<DetailedJobResponse> jobs;
    private List<DetailedCoursedProgramResponse> coursedPrograms;
    private List<DetailedAcademicEducationResponse> academicEducationList;
    private List<DetailedInnovationProcessResponse> innovationProcesses;
}
