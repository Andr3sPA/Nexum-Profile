package co.edu.udea.nexum.profile.job.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobSalaryRangeResponse {
    private Long id;
    private String salary;
}
