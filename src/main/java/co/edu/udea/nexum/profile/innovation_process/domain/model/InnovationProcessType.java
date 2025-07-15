package co.edu.udea.nexum.profile.innovation_process.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class InnovationProcessType implements Model<Long> {
    private Long id;
    private String name;
    private String description;

    public InnovationProcessType(InnovationProcessTypeBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static InnovationProcessTypeBuilder builder() {
        return new InnovationProcessTypeBuilder();
    }

    public static class InnovationProcessTypeBuilder implements BaseBuilder<InnovationProcessType> {
        private Long id;
        private String name;
        private String description;

        public InnovationProcessTypeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public InnovationProcessTypeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InnovationProcessTypeBuilder description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public InnovationProcessType build() {
            return new InnovationProcessType(this);
        }
    }
}
