package co.edu.udea.nexum.profile.coursed_program.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class ProgramVersion implements Model<Long> {
    private Long id;
    private String name;
    private short version;

    public ProgramVersion(ProgramBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.version = builder.version;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public static ProgramBuilder builder() {
        return new ProgramBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
    }

    public static class ProgramBuilder implements BaseBuilder<ProgramVersion> {
        private Long id;
        private String name;
        private short version;

        public ProgramBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProgramBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProgramBuilder version(short version) {
            this.version = version;
            return this;
        }

        public ProgramVersion build() {
            return new ProgramVersion(this);
        }
    }

}
