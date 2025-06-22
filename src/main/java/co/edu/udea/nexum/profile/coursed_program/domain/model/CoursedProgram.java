package co.edu.udea.nexum.profile.coursed_program.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;

@Generated
public class CoursedProgram implements Model<Long> {
    private Long id;
    private User user;
    private ProgramVersion programVersion;
    private Integer graduationYear;

    public CoursedProgram(CoursedProgramBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.programVersion = builder.programVersion;
        this.graduationYear = builder.graduationYear;
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

    public static CoursedProgramBuilder builder(){
        return new CoursedProgramBuilder();
    }

    @Generated
    public static class CoursedProgramBuilder implements BaseBuilder<CoursedProgram> {
        private Long id;
        private User user;
        private ProgramVersion programVersion;
        private Integer graduationYear;

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
        @Override
        public CoursedProgram build() {
            return new CoursedProgram(this);
        }
    }
}
