package co.edu.udea.nexum.profile.user.application.dto.response.detailed;

import co.edu.udea.nexum.profile.common.application.dto.response.BaseResponse;
import co.edu.udea.nexum.profile.innovation_process.application.dto.response.InnovationProcessTypeResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DetailedInnovationProcessResponse implements BaseResponse {
    private Long id;
    private InnovationProcessTypeResponse type;
    private String name;
    private String description;
    private String link;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
