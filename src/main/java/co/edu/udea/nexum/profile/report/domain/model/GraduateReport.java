package co.edu.udea.nexum.profile.report.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GraduateReport {
    private List<ReportUser> users;

    private String program;
    private String gender;
    private String country;
    private String state;
    private String city;

    private Long totalGraduates;
    private Long womanCount;
    private Long manCount;
    private Long nonBinaryCount;
    private Long otherCount;

    private Double womanPercentage;
    private Double manPercentage;
    private Double nonBinaryPercentage;
    private Double otherPercentage;

    private Integer startYear;
    private Integer endYear;
}
