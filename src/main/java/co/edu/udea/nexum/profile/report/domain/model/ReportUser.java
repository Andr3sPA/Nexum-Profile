package co.edu.udea.nexum.profile.report.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportUser {
    private String names;
    private String lastnames;
    private String email;
    private String mobile;
    private String graduateGender;
    private String occupation;
    private String identityDocument;
    private Integer graduationYear;
}
