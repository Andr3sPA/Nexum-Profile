package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;

import java.util.List;

@Generated
public class DetailedUserCoursedProgram implements Model<Long> {
    private Long id;
    private ProgramVersion programVersion;
    private Integer graduationYear;
    private List<DetailedUserProgramOpinion> programOpinions;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ProgramVersion getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(ProgramVersion programVersion) {
        this.programVersion = programVersion;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public List<DetailedUserProgramOpinion> getProgramOpinions() {
        return programOpinions;
    }

    public void setProgramOpinions(List<DetailedUserProgramOpinion> programOpinions) {
        this.programOpinions = programOpinions;
    }
}
