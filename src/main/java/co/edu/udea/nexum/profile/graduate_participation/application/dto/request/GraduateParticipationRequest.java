package co.edu.udea.nexum.profile.graduate_participation.application.dto.request;

import co.edu.udea.nexum.profile.common.application.dto.request.BaseRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.graduate_participation.application.utils.constants.GraduateParticipationConstants.*;

@Data
@Builder
public class GraduateParticipationRequest implements BaseRequest {

    @NotNull(message = USER_ID_NOT_NULL_MESSAGE)
    private UUID userId;

    @NotEmpty(message = CONTINUOUS_EDUCATION_INTERESTS_NOT_EMPTY_MESSAGE)
    private List<String> continuousEducationInterests;

    @NotNull(message = SPEAKER_NOT_NULL_MESSAGE)
    private Boolean willingToBeSpeaker;

    @NotNull(message = PROFESSOR_NOT_NULL_MESSAGE)
    private Boolean willingToBeProfessor;

    @NotNull(message = NON_FORMAL_EDUCATOR_NOT_NULL_MESSAGE)
    private Boolean willingToTeachNonFormalEducation;

    @NotNull(message = POSTGRADUATE_STUDENT_NOT_NULL_MESSAGE)
    private Boolean willingToBePostgraduateStudent;

    @NotNull(message = NON_FORMAL_STUDENT_NOT_NULL_MESSAGE)
    private Boolean willingToBeNonFormalStudent;

    @NotNull(message = REPRESENTATIVE_NOT_NULL_MESSAGE)
    private Boolean willingToBeGraduateRepresentative;

    @NotNull(message = ALUMNI_MEETINGS_NOT_NULL_MESSAGE)
    private Boolean willingToAttendAlumniMeetings;

    @NotNull(message = ALUMNI_ACTIVITIES_NOT_NULL_MESSAGE)
    private Boolean willingToParticipateInAlumniActivities;
}
