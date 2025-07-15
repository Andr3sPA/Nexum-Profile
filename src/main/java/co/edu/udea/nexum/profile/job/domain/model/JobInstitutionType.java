package co.edu.udea.nexum.profile.job.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class JobInstitutionType implements Model<Long> {
    private Long id;
    private String name;
    private String description;

    public JobInstitutionType(JobInstitutionTypeBuilder builder) {
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

    public static JobInstitutionTypeBuilder builder() {
        return new JobInstitutionTypeBuilder();
    }

    public static class JobInstitutionTypeBuilder implements BaseBuilder<JobInstitutionType> {
        private Long id;
        private String name;
        private String description;

        public JobInstitutionTypeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public JobInstitutionTypeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public JobInstitutionTypeBuilder description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public JobInstitutionType build() {
            return new JobInstitutionType(this);
        }
    }
}
