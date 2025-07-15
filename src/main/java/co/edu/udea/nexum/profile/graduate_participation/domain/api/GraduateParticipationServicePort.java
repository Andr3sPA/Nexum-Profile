package co.edu.udea.nexum.profile.graduate_participation.domain.api;

import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;

import java.util.List;
import java.util.UUID;

public interface GraduateParticipationServicePort extends BaseCrudServicePort<Long, GraduateParticipation> {
    List<GraduateParticipation> findByUserId(UUID userId);
}