package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;

import java.time.LocalDateTime;
import java.util.List;

@Generated
public class DetailedUserProgramOpinion implements Model<Long> {
    private Long id;
    private String strengths;
    private String weaknesses;
    private List<String> suggestedCompetencies;
    private boolean whatsappGroupMember;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
