package co.edu.udea.nexum.profile.innovation_process.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class InnovationProcessUserResponse {
    private UUID id;
    private String name;
    private String lastName;
}
