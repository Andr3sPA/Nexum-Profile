package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.PaginationDataMapper;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import co.edu.udea.nexum.profile.user.domain.model.full.FullUser;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.FullUserEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.mapper.UserEntityMapper;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository.FullUserRepository;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository.UserRepository;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.specification.UserSpec;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter extends BaseCrudAdapterImpl<UUID, User, UserEntity> implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final FullUserRepository fullUserRepository;
    private final PaginationDataMapper paginationDataMapper;

    @Override
    protected BaseEntityMapper<User, UserEntity> getMapper() {
        return userEntityMapper;
    }

    @Override
    protected CrudRepository<UserEntity, UUID> getRepository() {
        return userRepository;
    }

    @Override
    public User findByIdentityDocument(String identityDocument) {
        return userEntityMapper.toDomain(
                userRepository.findByIdentityDocument(identityDocument)
        );
    }

    @Override
    public DomainPage<FullUser> findAllFiltered(UserFilter filter, PaginationData paginationData) {
        Pageable pageable = paginationDataMapper.toJPA(paginationData).createPageable();

        // Create filter without complementary studies for database query
        UserFilter dbFilter = UserFilter.builder()
                .identityDocument(filter.getIdentityDocument())
                .identityDocumentTypeId(filter.getIdentityDocumentTypeId())
                .name(filter.getName())
                .middleName(filter.getMiddleName())
                .lastname(filter.getLastname())
                .secondLastname(filter.getSecondLastname())
                .gender(filter.getGender())
                .birthdate(filter.getBirthdate())
                .companyName(filter.getCompanyName())
                .jobCountry(filter.getJobCountry())
                .position(filter.getPosition())
                .relatedToProgram(filter.getRelatedToProgram())
                .salaryRangeId(filter.getSalaryRangeId())
                .jobDelayId(filter.getJobDelayId())
                .jobAreaId(filter.getJobAreaId())
                .institutionTypeId(filter.getInstitutionTypeId())
                .innovationTypeId(filter.getInnovationTypeId())
                .innovationName(filter.getInnovationName())
                .startYear(filter.getStartYear())
                .endYear(filter.getEndYear())
                .programIds(filter.getProgramIds())
                .address(filter.getAddress())
                .country(filter.getCountry())
                .state(filter.getState())
                .city(filter.getCity())
                .mobile(filter.getMobile())
                .email(filter.getEmail())
                .academicEmail(filter.getAcademicEmail())
                .whatsappAuthorization(filter.getWhatsappAuthorization())
                .role(filter.getRole())
                .studyType(filter.getStudyType())
                .studyName(filter.getStudyName())
                .academicInstitution(filter.getAcademicInstitution())
                .academicCountry(filter.getAcademicCountry())
                .programVersionIds(filter.getProgramVersionIds())
                .build();

        Specification<FullUserEntity> userSpecification = UserSpec.filterBy(dbFilter);
        Page<FullUserEntity> dbResults = fullUserRepository.findAll(userSpecification, pageable);

        // Apply fuzzy search filtering in Java if complementary studies are specified
        List<FullUserEntity> filteredEntities = dbResults.getContent();
        if (filter.getComplementaryStudies() != null && !filter.getComplementaryStudies().isEmpty()) {
            filteredEntities = applyFuzzySearchFiltering(filteredEntities, filter.getComplementaryStudies());
        }

        // Create new page with filtered results
        Page<FullUserEntity> filteredPage = new PageImpl<>(
                filteredEntities,
                dbResults.getPageable(),
                filteredEntities.size() // Note: This is an approximation since we're filtering after pagination
        );

        return userEntityMapper.toDomainPage(filteredPage);
    }

    @Override
    public List<FullUser> findAllFilteredForReport(UserFilter filterRequest) {
        Specification<FullUserEntity> userSpecification = UserSpec.filterBy(filterRequest);
        return userEntityMapper.toFullDomain(
                fullUserRepository.findAll(userSpecification)
        );
    }

    @Override
    public boolean existsById(UUID id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByIdentityDocument(String identityDocument) {
        return userRepository.existsByIdentityDocument(identityDocument);
    }

    @Override
    public FullUser findFullById(UUID id) {
        return userEntityMapper.toFullDomain(
                fullUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    private List<FullUserEntity> applyFuzzySearchFiltering(List<FullUserEntity> entities, List<String> complementaryStudies) {
        if (complementaryStudies == null || complementaryStudies.isEmpty()) {
            return entities;
        }

        LevenshteinDistance levenshtein = new LevenshteinDistance();
        final int MAX_DISTANCE = 2; // Maximum Levenshtein distance for fuzzy match

        return entities.stream()
                .filter(entity -> {
                    if (entity.getAcademicEducationList() == null || entity.getAcademicEducationList().isEmpty()) {
                        return false; // No academic education to match against
                    }

                    return entity.getAcademicEducationList().stream()
                            .anyMatch(academicEducation ->
                                complementaryStudies.stream()
                                        .anyMatch(searchTerm -> {
                                            if (academicEducation.getStudyName() == null) {
                                                return false;
                                            }

                                            String studyName = academicEducation.getStudyName().toLowerCase();
                                            String term = searchTerm.toLowerCase();

                                            // Exact match
                                            if (studyName.equals(term)) {
                                                return true;
                                            }

                                            // Fuzzy match with Levenshtein distance <= MAX_DISTANCE
                                            Integer distance = levenshtein.apply(studyName, term);
                                            return distance != null && distance <= MAX_DISTANCE;
                                        })
                            );
                })
                .collect(Collectors.toList());
    }
}
