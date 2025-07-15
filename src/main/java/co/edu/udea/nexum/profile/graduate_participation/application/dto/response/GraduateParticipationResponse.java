package co.edu.udea.nexum.profile.graduate_participation.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class GraduateParticipationResponse implements BaseResponse {
    private Long id;
    private GraduateParticipationUserResponse user;
    private List<String> continuousEducationInterests;
    private Boolean willingToBeSpeaker;
    private Boolean willingToBeProfessor;
    private Boolean willingToTeachNonFormalEducation;
    private Boolean willingToBePostgraduateStudent;
    private Boolean willingToBeNonFormalStudent;
    private Boolean willingToBeGraduateRepresentative;
    private Boolean willingToAttendAlumniMeetings;
    private Boolean willingToParticipateInAlumniActivities;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
