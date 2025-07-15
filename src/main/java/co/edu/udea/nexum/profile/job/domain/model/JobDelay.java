package co.edu.udea.nexum.profile.job.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.model.OrderableModel;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class JobDelay implements Model<Long>, OrderableModel {
    private Long id;
    private String label;
    private Integer order;
    private Boolean active;

    public JobDelay(JobDelayBuilder builder) {
        this.id = builder.id;
        this.label = builder.label;
        this.order = builder.order;
        this.active = builder.active;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public Integer getOrder() {
        return order;
    }

    @Override
    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static JobDelayBuilder builder() {
        return new JobDelayBuilder();
    }

    public static class JobDelayBuilder implements BaseBuilder<JobDelay> {
        private Long id;
        private String label;
        private Integer order;
        private Boolean active;

        public JobDelayBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public JobDelayBuilder label(String label) {
            this.label = label;
            return this;
        }

        public JobDelayBuilder order(Integer order) {
            this.order = order;
            return this;
        }

        public JobDelayBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        @Override
        public JobDelay build() {
            return new JobDelay(this);
        }
    }
}
