package co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.contact_information.domain.spi.ContactInformationPersistencePort;
import co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.entity.ContactInformationEntity;
import co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.mapper.ContactInformationEntityMapper;
import co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.repository.ContactInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ContactInformationJpaAdapter
        extends BaseCrudAdapterImpl<Long, ContactInformation, ContactInformationEntity>
        implements ContactInformationPersistencePort {

    private final ContactInformationRepository contactInformationRepository;
    private final ContactInformationEntityMapper contactInformationEntityMapper;

    @Override
    protected BaseEntityMapper<ContactInformation, ContactInformationEntity> getMapper() {
        return contactInformationEntityMapper;
    }

    @Override
    protected CrudRepository<ContactInformationEntity, Long> getRepository() {
        return contactInformationRepository;
    }

    @Override
    public ContactInformation findCurrentByUserId(UUID userId) {
        return contactInformationEntityMapper.toDomain(
                contactInformationRepository.findTopByUser_IdOrderByCreationDateDesc(userId).orElse(null)
        );
    }

    @Override
    public ContactInformation findFirstByUserId(UUID userId) {
        return contactInformationEntityMapper.toDomain(
                contactInformationRepository.findFirstByUser_IdOrderByCreationDateAsc(userId).orElse(null)
        );
    }
}
