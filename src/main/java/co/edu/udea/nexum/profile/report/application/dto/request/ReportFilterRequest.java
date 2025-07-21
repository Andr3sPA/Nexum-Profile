package co.edu.udea.nexum.profile.report.application.dto.request;

import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportFilterRequest {

    private Gender gender;

    private String country;
    private String state;
    private String city;

    private Integer startYear;
    private Integer endYear;

    private Long programId;
}