package co.edu.udea.nexum.profile.user.application.dto.response;

import co.edu.udea.nexum.profile.innovation_process.application.dto.response.InnovationProcessTypeResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DetailedGraduateParticipationResponse {
    private Long id;
    private List<InnovationProcessTypeResponse> participatedInnovationProcesses;
    private List<String> continuousEducationInterests;
    private Boolean willingToBeSpeaker;
    private Boolean willingToBeProfessor;
    private Boolean willingToTeachNonFormalEducation;
    private Boolean willingToBePostgraduateStudent;
    private Boolean willingToBeNonFormalStudent;
    private Boolean willingToBeGraduateRepresentative;
    private Boolean willingToAttendAlumniMeetings;
    private Boolean willingToParticipateInAlumniActivities;
}
