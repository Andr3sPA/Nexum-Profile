package co.edu.udea.nexum.profile.graduate_participation.domain.spi;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;

import java.util.List;
import java.util.UUID;

public interface GraduateParticipationPersistencePort extends BaseCrudPersistencePort<Long, GraduateParticipation> {
    List<GraduateParticipation> findByUserId(UUID userId);
    List<GraduateParticipation> findByUserIdOrderByDateDesc(UUID userId);
}