package co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.academic_education.domain.spi.AcademicEducationPersistencePort;
import co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.entity.AcademicEducationEntity;
import co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.mapper.AcademicEducationEntityMapper;
import co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.repository.AcademicEducationRepository;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AcademicEducationJpaAdapter
        extends BaseCrudAdapterImpl<Long, AcademicEducation, AcademicEducationEntity>
        implements AcademicEducationPersistencePort {

    private final AcademicEducationRepository academicEducationRepository;
    private final AcademicEducationEntityMapper academicEducationEntityMapper;

    @Override
    protected BaseEntityMapper<AcademicEducation, AcademicEducationEntity> getMapper() {
        return academicEducationEntityMapper;
    }

    @Override
    protected CrudRepository<AcademicEducationEntity, Long> getRepository() {
        return academicEducationRepository;
    }

    @Override
    public List<AcademicEducation> findAllByUserId(UUID id) {
        return academicEducationEntityMapper.toDomains(
                academicEducationRepository.findAllByUser_Id(id)
        );
    }
}
