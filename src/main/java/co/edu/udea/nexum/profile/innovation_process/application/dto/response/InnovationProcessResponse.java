package co.edu.udea.nexum.profile.innovation_process.application.dto.response;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InnovationProcessResponse implements BaseResponse {
    private Long id;
    private InnovationProcessUserResponse user;
    private InnovationProcessTypeResponse type;
    private String name;
    private String description;
    private String link;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
