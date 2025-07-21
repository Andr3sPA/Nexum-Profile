package co.edu.udea.nexum.profile.coursed_program.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.domain.model.Program;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Generated
public class FullProgramVersion implements Model<Long> {
    private Long id;
    private Short version;
    private Integer startYear;
    private Integer endYear;
    private Program program;
}
