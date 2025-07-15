package co.edu.udea.nexum.profile.innovation_process.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InnovationProcessTypeResponse {
    private Long id;
    private String name;
    private String description;
}
