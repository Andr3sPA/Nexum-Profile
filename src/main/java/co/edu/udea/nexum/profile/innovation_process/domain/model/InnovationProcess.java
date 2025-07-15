package co.edu.udea.nexum.profile.innovation_process.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.time.LocalDateTime;

@Generated
public class InnovationProcess implements Model<Long>, AuditableModel {
    private Long id;
    private User user;
    private InnovationProcessType type;
    private String name;
    private String description;
    private String link;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Generated
    private InnovationProcess(InnovationProcessBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.type = builder.type;
        this.name = builder.name;
        this.description = builder.description;
        this.link = builder.link;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
    }

    public static InnovationProcessBuilder builder() {
        return new InnovationProcessBuilder();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public InnovationProcessType getType() {
        return type;
    }

    public void setType(InnovationProcessType type) {
        this.type = type;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public static class InnovationProcessBuilder implements BaseBuilder<InnovationProcess> {
        private Long id;
        private User user;
        private InnovationProcessType type;
        private String name;
        private String description;
        private String link;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public InnovationProcessBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public InnovationProcessBuilder type(InnovationProcessType type) {
            this.type = type;
            return this;
        }

        public InnovationProcessBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InnovationProcessBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InnovationProcessBuilder link(String link) {
            this.link = link;
            return this;
        }

        public InnovationProcessBuilder user(User user) {
            this.user = user;
            return this;
        }

        public InnovationProcessBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public InnovationProcessBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public InnovationProcess build() {
            return new InnovationProcess(this);
        }
    }
}
