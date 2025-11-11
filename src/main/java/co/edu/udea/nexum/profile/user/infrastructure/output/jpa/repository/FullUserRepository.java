package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.FullUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FullUserRepository extends JpaRepository<FullUserEntity, UUID> {
    Page<FullUserEntity> findAll(Specification<FullUserEntity> specification, Pageable pageable);
    List<FullUserEntity> findAll(Specification<FullUserEntity> specification);
    long count(Specification<FullUserEntity> specification);

    @Query("SELECT COUNT(DISTINCT u) FROM FullUserEntity u JOIN u.auth a WHERE a.role.name = co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName.GRADUATE")
    long countAllGraduates();

    @Query("SELECT COUNT(DISTINCT u) FROM FullUserEntity u JOIN u.auth a JOIN u.jobs j WHERE a.role.name = co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName.GRADUATE AND j.currentJob = true")
    long countAllEmployedGraduates();

    @Query("SELECT COUNT(DISTINCT u) FROM FullUserEntity u JOIN u.auth a JOIN u.jobs j WHERE a.role.name = co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName.GRADUATE AND u.id IN :userIds")
    long countEmployedGraduatesByIds(@Param("userIds") List<UUID> userIds);

    @Query("SELECT cp.programVersionId, COUNT(DISTINCT u), SUM(CASE WHEN EXISTS (SELECT 1 FROM u.jobs j WHERE j.currentJob = true) THEN 1 ELSE 0 END) " +
           "FROM FullUserEntity u " +
           "JOIN u.auth a " +
           "JOIN u.coursedPrograms cp " +
           "WHERE a.role.name = co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName.GRADUATE " +
           "GROUP BY cp.programVersionId " +
           "ORDER BY cp.programVersionId")
    List<Object[]> countGraduatesAndEmployedByProgram();
}
