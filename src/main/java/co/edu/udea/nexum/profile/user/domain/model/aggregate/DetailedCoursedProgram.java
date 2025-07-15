package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;

import java.util.List;

@Generated
public class DetailedCoursedProgram implements Model<Long> {

    private Long id;
    private ProgramVersion programVersion;
    private Integer graduationYear;
    private List<String> strengths;
    private List<String> weaknesses;
    private List<String> improvementSuggestions;

    @Generated
    private DetailedCoursedProgram(DetailedCoursedProgramBuilder builder) {
        this.id = builder.id;
        this.programVersion = builder.programVersion;
        this.graduationYear = builder.graduationYear;
        this.strengths = builder.strengths;
        this.weaknesses = builder.weaknesses;
        this.improvementSuggestions = builder.improvementSuggestions;
    }

    public static DetailedCoursedProgramBuilder builder() {
        return new DetailedCoursedProgramBuilder();
    }

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

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<String> getImprovementSuggestions() {
        return improvementSuggestions;
    }

    public void setImprovementSuggestions(List<String> improvementSuggestions) {
        this.improvementSuggestions = improvementSuggestions;
    }

    public static class DetailedCoursedProgramBuilder implements BaseBuilder<DetailedCoursedProgram> {
        private Long id;
        private ProgramVersion programVersion;
        private Integer graduationYear;
        private List<String> strengths;
        private List<String> weaknesses;
        private List<String> improvementSuggestions;

        public DetailedCoursedProgramBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DetailedCoursedProgramBuilder programVersion(ProgramVersion programVersion) {
            this.programVersion = programVersion;
            return this;
        }

        public DetailedCoursedProgramBuilder graduationYear(Integer graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }

        public DetailedCoursedProgramBuilder strengths(List<String> strengths) {
            this.strengths = strengths;
            return this;
        }

        public DetailedCoursedProgramBuilder weaknesses(List<String> weaknesses) {
            this.weaknesses = weaknesses;
            return this;
        }

        public DetailedCoursedProgramBuilder improvementSuggestions(List<String> improvementSuggestions) {
            this.improvementSuggestions = improvementSuggestions;
            return this;
        }

        @Override
        public DetailedCoursedProgram build() {
            return new DetailedCoursedProgram(this);
        }
    }
}
