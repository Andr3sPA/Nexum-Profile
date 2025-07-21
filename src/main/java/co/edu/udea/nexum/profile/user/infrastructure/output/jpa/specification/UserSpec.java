package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.specification;

import co.edu.udea.nexum.profile.academic_education.domain.utils.enums.StudyType;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.FullUserEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

public class UserSpec {

    public static final String ACADEMIC_EDUCATION_LIST = "academicEducationList";
    public static final String INSTITUTION = "institution";
    public static final String COUNTRY = "country";
    public static final String STUDY_NAME = "studyName";
    public static final String TYPE = "type";
    public static final String AUTH = "auth";
    public static final String ROLE = "role";
    public static final String NAME = "name";
    public static final String CONTACT_INFORMATION_LIST = "contactInformationList";
    public static final String WHATSAPP_AUTHORIZATION = "whatsappAuthorization";
    public static final String ACADEMIC_EMAIL = "academicEmail";
    public static final String EMAIL = "email";
    public static final String MOBILE = "mobile";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ADDRESS = "address";
    public static final String PROGRAM_VERSION_ID = "programVersionId";
    public static final String COURSED_PROGRAMS = "coursedPrograms";
    public static final String GRADUATION_YEAR = "graduationYear";
    public static final String INNOVATION_PROCESSES = "innovationProcesses";
    public static final String JOB_LIST = "jobs";
    public static final String INSTITUTION_TYPE_ID = "institutionTypeId";
    public static final String JOB_AREA_ID = "jobAreaId";
    public static final String JOB_DELAY_ID = "jobDelayId";
    public static final String SALARY_RANGE_ID = "salaryRangeId";
    public static final String RELATED_TO_PROGRAM = "relatedToProgram";
    public static final String POSITION = "position";
    public static final String COMPANY_NAME = "companyName";
    public static final String BIRTHDATE = "birthdate";
    public static final String GENDER = "gender";
    public static final String SECOND_LASTNAME = "secondLastname";
    public static final String LASTNAME = "lastname";
    public static final String MIDDLE_NAME = "middleName";
    public static final String ID_IDENTITY_DOCUMENT_TYPE = "idIdentityDocumentType";
    public static final String IDENTITY_DOCUMENT = "identityDocument";
    public static final String ID = "id";

    private UserSpec() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<FullUserEntity> filterBy(UserFilter filter) {
        return filter == null ? null : Specification
                .where(hasIdentityDocument(filter.getIdentityDocument()))
                .and(hasIdentityDocumentType(filter.getIdentityDocumentTypeId()))
                .and(hasNameLike(filter.getName()))
                .and(hasMiddleNameLike(filter.getMiddleName()))
                .and(hasLastnameLike(filter.getLastname()))
                .and(hasSecondLastnameLike(filter.getSecondLastname()))
                .and(hasGender(filter.getGender()))
                .and(hasBirthdate(filter.getBirthdate()))
                .and(hasJobCompanyNameLike(filter.getCompanyName()))
                .and(hasJobCountryLike(filter.getJobCountry()))
                .and(hasJobPositionLike(filter.getPosition()))
                .and(hasRelatedToProgram(filter.getRelatedToProgram()))
                .and(hasSalaryRangeId(filter.getSalaryRangeId()))
                .and(hasJobDelayId(filter.getJobDelayId()))
                .and(hasJobAreaId(filter.getJobAreaId()))
                .and(hasInstitutionTypeId(filter.getInstitutionTypeId()))
                .and(hasInnovationTypeId(filter.getInnovationTypeId()))
                .and(hasInnovationNameLike(filter.getInnovationName()))
                .and(hasGraduationYearRange(filter.getStartYear(), filter.getEndYear()))
                .and(hasProgramVersionIds(filter.getProgramVersionIds()))
                .and(hasAddressLike(filter.getAddress()))
                .and(hasCountryLike(filter.getCountry()))
                .and(hasStateLike(filter.getState()))
                .and(hasCityLike(filter.getCity()))
                .and(hasMobileLike(filter.getMobile()))
                .and(hasEmailLike(filter.getEmail()))
                .and(hasAcademicEmailLike(filter.getAcademicEmail()))
                .and(hasWhatsappAuthorization(filter.getWhatsappAuthorization()))
                .and(hasRole(filter.getRole()))
                .and(hasAcademicStudyType(filter.getStudyType()))
                .and(hasAcademicStudyNameLike(filter.getStudyName()))
                .and(hasAcademicInstitutionLike(filter.getAcademicInstitution()))
                .and(hasAcademicCountryLike(filter.getAcademicCountry()));
    }

    // Métodos privados por cada filtro

    private static Specification<FullUserEntity> hasIdentityDocument(String value) {
        return likeSpec(IDENTITY_DOCUMENT, value);
    }

    private static Specification<FullUserEntity> hasIdentityDocumentType(Long id) {
        return equalsSpec(ID_IDENTITY_DOCUMENT_TYPE, id);
    }

    private static Specification<FullUserEntity> hasNameLike(String value) {
        return likeSpec(NAME, value);
    }

    private static Specification<FullUserEntity> hasMiddleNameLike(String value) {
        return likeSpec(MIDDLE_NAME, value);
    }

    private static Specification<FullUserEntity> hasLastnameLike(String value) {
        return likeSpec(LASTNAME, value);
    }

    private static Specification<FullUserEntity> hasSecondLastnameLike(String value) {
        return likeSpec(SECOND_LASTNAME, value);
    }

    private static Specification<FullUserEntity> hasGender(Gender gender) {
        return equalsSpec(GENDER, gender);
    }

    private static Specification<FullUserEntity> hasBirthdate(LocalDate value) {
        return equalsSpec(BIRTHDATE, value);
    }

    // Job related
    private static Specification<FullUserEntity> hasJobCompanyNameLike(String value) {
        return joinLike(JOB_LIST, COMPANY_NAME, value);
    }

    private static Specification<FullUserEntity> hasJobCountryLike(String value) {
        return joinLike(JOB_LIST, COUNTRY, value);
    }

    private static Specification<FullUserEntity> hasJobPositionLike(String value) {
        return joinLike(JOB_LIST, POSITION, value);
    }

    private static Specification<FullUserEntity> hasRelatedToProgram(Boolean value) {
        return joinEquals(JOB_LIST, RELATED_TO_PROGRAM, value);
    }

    private static Specification<FullUserEntity> hasSalaryRangeId(Long value) {
        return joinEquals(JOB_LIST, SALARY_RANGE_ID, value);
    }

    private static Specification<FullUserEntity> hasJobDelayId(Long value) {
        return joinEquals(JOB_LIST, JOB_DELAY_ID, value);
    }

    private static Specification<FullUserEntity> hasJobAreaId(Long value) {
        return joinEquals(JOB_LIST, JOB_AREA_ID, value);
    }

    private static Specification<FullUserEntity> hasInstitutionTypeId(Long value) {
        return joinEquals(JOB_LIST, INSTITUTION_TYPE_ID, value);
    }

    // Innovation Process
    private static Specification<FullUserEntity> hasInnovationTypeId(Long value) {
        return joinEquals(INNOVATION_PROCESSES, TYPE, value);
    }

    private static Specification<FullUserEntity> hasInnovationNameLike(String value) {
        return joinLike(INNOVATION_PROCESSES, NAME, value);
    }

    // Coursed Program
    private static Specification<FullUserEntity> hasGraduationYearRange(Integer startYear, Integer endYear) {
        return (root, query, cb) -> {
            if (startYear == null && endYear == null) return cb.conjunction();

            var join = root.join(COURSED_PROGRAMS, JoinType.LEFT);
            if (startYear != null && endYear != null) return cb.between(join.get(GRADUATION_YEAR), startYear, endYear);
            else if (startYear != null) return cb.greaterThanOrEqualTo(join.get(GRADUATION_YEAR), startYear);
            else return cb.lessThanOrEqualTo(join.get(GRADUATION_YEAR), endYear);
        };
    }


    private static Specification<FullUserEntity> hasProgramVersionIds(List<Long> ids) {
        return (root, query, cb) -> {
            if (ids == null || ids.isEmpty()) {
                return cb.conjunction();
            }
            return root.join(COURSED_PROGRAMS, JoinType.LEFT)
                    .get(PROGRAM_VERSION_ID)
                    .in(ids);
        };
    }

    // Contact Info
    private static Specification<FullUserEntity> hasAddressLike(String value) {
        return joinLike(CONTACT_INFORMATION_LIST, ADDRESS, value);
    }

    private static Specification<FullUserEntity> hasCountryLike(String value) {
        return joinLike(CONTACT_INFORMATION_LIST, COUNTRY, value);
    }

    private static Specification<FullUserEntity> hasStateLike(String value) {
        return joinLike(CONTACT_INFORMATION_LIST, STATE, value);
    }


    private static Specification<FullUserEntity> hasCityLike(String value) {
        return joinLike(CONTACT_INFORMATION_LIST, CITY, value);
    }

    private static Specification<FullUserEntity> hasMobileLike(String value) {
        return joinLike(CONTACT_INFORMATION_LIST, MOBILE, value);
    }

    private static Specification<FullUserEntity> hasEmailLike(String value) {
        return joinLike(CONTACT_INFORMATION_LIST, EMAIL, value);
    }

    private static Specification<FullUserEntity> hasAcademicEmailLike(String value) {
        return joinLike(CONTACT_INFORMATION_LIST, ACADEMIC_EMAIL, value);
    }

    private static Specification<FullUserEntity> hasWhatsappAuthorization(Boolean value) {
        return joinEquals(CONTACT_INFORMATION_LIST, WHATSAPP_AUTHORIZATION, value);
    }

    // Auth
    private static Specification<FullUserEntity> hasRole(RoleName value) {
        return (root, query, cb) -> {
            if (value == null) return cb.conjunction();
            Join<Object, Object> authJoin = root.join(AUTH, JoinType.LEFT);

            if (value == RoleName.GRADUATE) {
                Join<Object, Object> roleJoin = authJoin.join(ROLE, JoinType.LEFT);
                return cb.or(
                        cb.equal(roleJoin.get(NAME), value),
                        cb.isNull(authJoin.get(ID))
                );
            } else return cb.equal(authJoin.join(ROLE).get(NAME), value);
        };
    }

    // Academic Education
    private static Specification<FullUserEntity> hasAcademicStudyType(StudyType value) {
        return joinEquals(ACADEMIC_EDUCATION_LIST, TYPE, value);
    }

    private static Specification<FullUserEntity> hasAcademicStudyNameLike(String value) {
        return joinLike(ACADEMIC_EDUCATION_LIST, STUDY_NAME, value);
    }

    private static Specification<FullUserEntity> hasAcademicInstitutionLike(String value) {
        return joinLike(ACADEMIC_EDUCATION_LIST, INSTITUTION, value);
    }

    private static Specification<FullUserEntity> hasAcademicCountryLike(String value) {
        return joinLike(ACADEMIC_EDUCATION_LIST, COUNTRY, value);
    }

    private static <T> Specification<FullUserEntity> equalsSpec(String field, T value) {
        return (root, query, cb) -> value == null ? cb.conjunction() : cb.equal(root.get(field), value);
    }

    private static Specification<FullUserEntity> likeSpec(String field, String value) {
        return (root, query, cb) -> value == null || value.isEmpty() ? cb.conjunction() : cb.like(cb.lower(root.get(field)), "%" + value.toLowerCase() + "%");
    }

    private static <T> Specification<FullUserEntity> joinEquals(String relation, String field, T value) {
        return (root, query, cb) -> value == null ? cb.conjunction() : cb.equal(root.join(relation, JoinType.LEFT).get(field), value);
    }

    private static Specification<FullUserEntity> joinLike(String relation, String field, String value) {
        return (root, query, cb) -> value == null || value.isEmpty() ? cb.conjunction() : cb.like(cb.lower(root.join(relation, JoinType.LEFT).get(field)), "%" + value.toLowerCase() + "%");
    }
}
