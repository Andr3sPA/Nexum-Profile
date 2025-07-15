package co.edu.udea.nexum.profile.job.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class JobUserResponse {
    private UUID id;
    private String name;
    private String lastname;
}
