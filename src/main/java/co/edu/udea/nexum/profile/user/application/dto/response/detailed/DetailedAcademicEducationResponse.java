package co.edu.udea.nexum.profile.user.application.dto.response.detailed;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailedAcademicEducationResponse {
    private Long id;
    private String type;
    private String studyName;
    private String institution;
    private String country;
}
