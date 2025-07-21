package co.edu.udea.nexum.profile.graduate_participation.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Generated
@Getter
public class GraduateParticipation implements Model<Long>, AuditableModel {

    private Long id;
    private User user;
    private List<String> continuousEducationInterests;
    private Boolean willingToBeSpeaker;
    private Boolean willingToBeProfessor;
    private Boolean willingToTeachNonFormalEducation;
    private Boolean willingToBePostgraduateStudent;
    private Boolean willingToBeNonFormalStudent;
    private Boolean willingToBeGraduateRepresentative;
    private Boolean willingToAttendAlumniMeetings;
    private Boolean willingToParticipateInAlumniActivities;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    public GraduateParticipation(GraduateParticipationBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.continuousEducationInterests = builder.continuousEducationInterests;
        this.willingToBeSpeaker = builder.willingToBeSpeaker;
        this.willingToBeProfessor = builder.willingToBeProfessor;
        this.willingToTeachNonFormalEducation = builder.willingToTeachNonFormalEducation;
        this.willingToBePostgraduateStudent = builder.willingToBePostgraduateStudent;
        this.willingToBeNonFormalStudent = builder.willingToBeNonFormalStudent;
        this.willingToBeGraduateRepresentative = builder.willingToBeGraduateRepresentative;
        this.willingToAttendAlumniMeetings = builder.willingToAttendAlumniMeetings;
        this.willingToParticipateInAlumniActivities = builder.willingToParticipateInAlumniActivities;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
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

    public List<String> getContinuousEducationInterests() {
        return continuousEducationInterests;
    }

    public void setContinuousEducationInterests(List<String> continuousEducationInterests) {
        this.continuousEducationInterests = continuousEducationInterests;
    }

    public Boolean getWillingToBeSpeaker() {
        return willingToBeSpeaker;
    }

    public void setWillingToBeSpeaker(Boolean willingToBeSpeaker) {
        this.willingToBeSpeaker = willingToBeSpeaker;
    }

    public Boolean getWillingToBeProfessor() {
        return willingToBeProfessor;
    }

    public void setWillingToBeProfessor(Boolean willingToBeProfessor) {
        this.willingToBeProfessor = willingToBeProfessor;
    }

    public Boolean getWillingToTeachNonFormalEducation() {
        return willingToTeachNonFormalEducation;
    }

    public void setWillingToTeachNonFormalEducation(Boolean willingToTeachNonFormalEducation) {
        this.willingToTeachNonFormalEducation = willingToTeachNonFormalEducation;
    }

    public Boolean getWillingToBePostgraduateStudent() {
        return willingToBePostgraduateStudent;
    }

    public void setWillingToBePostgraduateStudent(Boolean willingToBePostgraduateStudent) {
        this.willingToBePostgraduateStudent = willingToBePostgraduateStudent;
    }

    public Boolean getWillingToBeNonFormalStudent() {
        return willingToBeNonFormalStudent;
    }

    public void setWillingToBeNonFormalStudent(Boolean willingToBeNonFormalStudent) {
        this.willingToBeNonFormalStudent = willingToBeNonFormalStudent;
    }

    public Boolean getWillingToBeGraduateRepresentative() {
        return willingToBeGraduateRepresentative;
    }

    public void setWillingToBeGraduateRepresentative(Boolean willingToBeGraduateRepresentative) {
        this.willingToBeGraduateRepresentative = willingToBeGraduateRepresentative;
    }

    public Boolean getWillingToAttendAlumniMeetings() {
        return willingToAttendAlumniMeetings;
    }

    public void setWillingToAttendAlumniMeetings(Boolean willingToAttendAlumniMeetings) {
        this.willingToAttendAlumniMeetings = willingToAttendAlumniMeetings;
    }

    public Boolean getWillingToParticipateInAlumniActivities() {
        return willingToParticipateInAlumniActivities;
    }

    public void setWillingToParticipateInAlumniActivities(Boolean willingToParticipateInAlumniActivities) {
        this.willingToParticipateInAlumniActivities = willingToParticipateInAlumniActivities;
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

    public static GraduateParticipationBuilder builder(){
        return new GraduateParticipationBuilder();
    }

    @Generated
    public static class GraduateParticipationBuilder implements BaseBuilder<GraduateParticipation> {
        private Long id;
        private User user;
        private List<String> continuousEducationInterests;
        private Boolean willingToBeSpeaker;
        private Boolean willingToBeProfessor;
        private Boolean willingToTeachNonFormalEducation;
        private Boolean willingToBePostgraduateStudent;
        private Boolean willingToBeNonFormalStudent;
        private Boolean willingToBeGraduateRepresentative;
        private Boolean willingToAttendAlumniMeetings;
        private Boolean willingToParticipateInAlumniActivities;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public GraduateParticipationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GraduateParticipationBuilder user(User user) {
            this.user = user;
            return this;
        }

        public GraduateParticipationBuilder continuousEducationInterests(List<String> interests) {
            this.continuousEducationInterests = interests;
            return this;
        }

        public GraduateParticipationBuilder willingToBeSpeaker(Boolean value) {
            this.willingToBeSpeaker = value;
            return this;
        }

        public GraduateParticipationBuilder willingToBeProfessor(Boolean value) {
            this.willingToBeProfessor = value;
            return this;
        }

        public GraduateParticipationBuilder willingToTeachNonFormalEducation(Boolean value) {
            this.willingToTeachNonFormalEducation = value;
            return this;
        }

        public GraduateParticipationBuilder willingToBePostgraduateStudent(Boolean value) {
            this.willingToBePostgraduateStudent = value;
            return this;
        }

        public GraduateParticipationBuilder willingToBeNonFormalStudent(Boolean value) {
            this.willingToBeNonFormalStudent = value;
            return this;
        }

        public GraduateParticipationBuilder willingToBeGraduateRepresentative(Boolean value) {
            this.willingToBeGraduateRepresentative = value;
            return this;
        }

        public GraduateParticipationBuilder willingToAttendAlumniMeetings(Boolean value) {
            this.willingToAttendAlumniMeetings = value;
            return this;
        }

        public GraduateParticipationBuilder willingToParticipateInAlumniActivities(Boolean value) {
            this.willingToParticipateInAlumniActivities = value;
            return this;
        }

        public GraduateParticipationBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public GraduateParticipationBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public GraduateParticipation build() {
            return new GraduateParticipation(this);
        }
    }
}
