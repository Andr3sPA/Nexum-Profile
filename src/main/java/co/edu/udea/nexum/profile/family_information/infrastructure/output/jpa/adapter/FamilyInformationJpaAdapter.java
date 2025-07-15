package co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import co.edu.udea.nexum.profile.family_information.domain.spi.FamilyInformationPersistencePort;
import co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.entity.FamilyInformationEntity;
import co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.mapper.FamilyInformationEntityMapper;
import co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.repository.FamilyInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FamilyInformationJpaAdapter
        extends BaseCrudAdapterImpl<Long, FamilyInformation, FamilyInformationEntity>
        implements FamilyInformationPersistencePort {

    private final FamilyInformationRepository familyInformationRepository;
    private final FamilyInformationEntityMapper familyInformationEntityMapper;

    @Override
    protected BaseEntityMapper<FamilyInformation, FamilyInformationEntity> getMapper() {
        return familyInformationEntityMapper;
    }

    @Override
    protected CrudRepository<FamilyInformationEntity, Long> getRepository() {
        return familyInformationRepository;
    }

    @Override
    public FamilyInformation findLastByUserId(UUID userId) {
        return familyInformationEntityMapper.toDomain(
                familyInformationRepository.findTopByUser_IdOrderByCreationDateDesc(userId).orElse(null)
        );
    }
}
