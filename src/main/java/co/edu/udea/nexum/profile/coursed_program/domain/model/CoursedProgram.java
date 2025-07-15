package co.edu.udea.nexum.profile.coursed_program.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Generated
public class CoursedProgram implements Model<Long>, AuditableModel {

    private Long id;
    private User user;
    private ProgramVersion programVersion;
    private Integer graduationYear;

    private List<String> strengths;
    private List<String> weaknesses;
    private List<String> improvementSuggestions;

    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    public CoursedProgram(CoursedProgramBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.programVersion = builder.programVersion;
        this.graduationYear = builder.graduationYear;
        this.strengths = builder.strengths;
        this.weaknesses = builder.weaknesses;
        this.improvementSuggestions = builder.improvementSuggestions;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
    }

    public static CoursedProgramBuilder builder() {
        return new CoursedProgramBuilder();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Generated
    public static class CoursedProgramBuilder implements BaseBuilder<CoursedProgram> {

        private Long id;
        private User user;
        private ProgramVersion programVersion;
        private Integer graduationYear;

        private List<String> strengths;
        private List<String> weaknesses;
        private List<String> improvementSuggestions;

        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public CoursedProgramBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CoursedProgramBuilder user(User user) {
            this.user = user;
            return this;
        }

        public CoursedProgramBuilder programVersion(ProgramVersion programVersion) {
            this.programVersion = programVersion;
            return this;
        }

        public CoursedProgramBuilder graduationYear(Integer graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }

        public CoursedProgramBuilder strengths(List<String> strengths) {
            this.strengths = strengths;
            return this;
        }

        public CoursedProgramBuilder weaknesses(List<String> weaknesses) {
            this.weaknesses = weaknesses;
            return this;
        }

        public CoursedProgramBuilder improvementSuggestions(List<String> suggestions) {
            this.improvementSuggestions = suggestions;
            return this;
        }

        public CoursedProgramBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public CoursedProgramBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public CoursedProgram build() {
            return new CoursedProgram(this);
        }
    }
}
