package co.edu.udea.nexum.profile.job.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class SalaryRange implements Model<Long> {

    private Long id;
    private String salary;
    private Integer order;

    public SalaryRange(SalaryRangeBuilder builder) {
        this.id = builder.id;
        this.salary = builder.salary;
        this.order = builder.order;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
    public static SalaryRangeBuilder builder() {
        return new SalaryRangeBuilder();
    }

    public static class SalaryRangeBuilder implements BaseBuilder<SalaryRange> {
        private Long id;
        private String salary;
        private Integer order;

        public SalaryRangeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public SalaryRangeBuilder salary(String salary) {
            this.salary = salary;
            return this;
        }

        public SalaryRangeBuilder order(Integer order) {
            this.order = order;
            return this;
        }

        @Override
        public SalaryRange build() {
            return new SalaryRange(this);
        }
    }
}
