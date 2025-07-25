package co.edu.udea.nexum.profile.report.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportUserResponse {
    private String names;
    private String lastnames;
    private String email;
    private String mobile;
    private String graduateGender;
    private String program;
    private String occupation;
    private String identityDocument;
    private Integer graduationYear;
}
