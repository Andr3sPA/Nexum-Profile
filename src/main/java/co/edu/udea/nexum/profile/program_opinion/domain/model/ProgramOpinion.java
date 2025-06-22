package co.edu.udea.nexum.profile.program_opinion.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;

import java.time.LocalDateTime;
import java.util.List;

@Generated
public class ProgramOpinion implements Model<Long>, AuditableModel {
    private Long id;
    private CoursedProgram coursedProgram;
    private String strengths;
    private String weaknesses;
    private List<String> suggestedCompetencies;
    private boolean whatsappGroupMember;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Generated
    public ProgramOpinion(ProgramOpinionBuilder builder) {
        this.id = builder.id;
        this.coursedProgram = builder.coursedProgram;
        this.strengths = builder.strengths;
        this.weaknesses = builder.weaknesses;
        this.suggestedCompetencies = builder.suggestedCompetencies;
        this.whatsappGroupMember = builder.whatsappGroupMember;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public CoursedProgram getCoursedProgram() {
        return coursedProgram;
    }

    public void setCoursedProgram(CoursedProgram coursedProgram) {
        this.coursedProgram = coursedProgram;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<String> getSuggestedCompetencies() {
        return suggestedCompetencies;
    }

    public void setSuggestedCompetencies(List<String> suggestedCompetencies) {
        this.suggestedCompetencies = suggestedCompetencies;
    }

    public boolean isWhatsappGroupMember() {
        return whatsappGroupMember;
    }

    public void setWhatsappGroupMember(boolean whatsappGroupMember) {
        this.whatsappGroupMember = whatsappGroupMember;
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

    public static ProgramOpinionBuilder builder() {
        return new ProgramOpinionBuilder();
    }

    @Generated
    public static class ProgramOpinionBuilder implements BaseBuilder<ProgramOpinion> {
        private Long id;
        private CoursedProgram coursedProgram;
        private String strengths;
        private String weaknesses;
        private List<String> suggestedCompetencies;
        private boolean whatsappGroupMember;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public ProgramOpinionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProgramOpinionBuilder coursedProgram(CoursedProgram coursedProgram) {
            this.coursedProgram = coursedProgram;
            return this;
        }

        public ProgramOpinionBuilder strengths(String strengths) {
            this.strengths = strengths;
            return this;
        }

        public ProgramOpinionBuilder weaknesses(String weaknesses) {
            this.weaknesses = weaknesses;
            return this;
        }

        public ProgramOpinionBuilder suggestedCompetencies(List<String> suggestedCompetencies) {
            this.suggestedCompetencies = suggestedCompetencies;
            return this;
        }

        public ProgramOpinionBuilder whatsappGroupMember(boolean whatsappGroupMember) {
            this.whatsappGroupMember = whatsappGroupMember;
            return this;
        }

        public ProgramOpinionBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public ProgramOpinionBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public ProgramOpinion build() {
            return new ProgramOpinion(this);
        }
    }
}
