package co.edu.udea.nexum.profile.user.domain.model.basic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicProgram {
    private String code;
    private String name;
}
