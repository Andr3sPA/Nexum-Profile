package co.edu.udea.nexum.profile.user.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgramVersionResponse {
    private Long id;
    private String name;
    private short version;
}
