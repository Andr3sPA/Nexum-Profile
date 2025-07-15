package co.edu.udea.nexum.profile.graduate_participation.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GraduateParticipationUserResponse {
    private UUID id;
    private String fullName;
    private String email;
}
