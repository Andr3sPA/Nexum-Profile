package co.edu.udea.nexum.profile.coursed_program.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Program {
    private Long id;
    private String name;
    private String code;
}
