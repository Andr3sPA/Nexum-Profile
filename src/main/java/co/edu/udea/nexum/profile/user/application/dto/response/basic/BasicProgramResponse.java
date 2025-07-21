package co.edu.udea.nexum.profile.user.application.dto.response.basic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicProgramResponse {
    private String code;
    private String name;
}
