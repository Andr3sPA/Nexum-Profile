package co.edu.udea.nexum.profile.report.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.model.aggregate.FullProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.report.domain.api.ReportServicePort;
import co.edu.udea.nexum.profile.report.domain.model.ReportUser;
import co.edu.udea.nexum.profile.report.domain.model.GraduateReport;
import co.edu.udea.nexum.profile.report.domain.spi.ReportGenerationPort;
import co.edu.udea.nexum.profile.report.domain.utils.enums.ReportFormat;
import co.edu.udea.nexum.profile.report.domain.utils.functions.ReportHelper;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import co.edu.udea.nexum.profile.user.domain.model.full.FullUser;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static co.edu.udea.nexum.profile.report.domain.utils.constants.ReportConstants.*;

public class ReportUseCase implements ReportServicePort {

    private final UserPersistencePort userPersistencePort;
    private final ReportGenerationPort reportGenerationPort;
    private final ProgramVersionPersistencePort programVersionPersistencePort;

    public ReportUseCase(
            UserPersistencePort userPersistencePort,
            ReportGenerationPort reportGenerationPort, ProgramVersionPersistencePort programVersionPersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.reportGenerationPort = reportGenerationPort;
        this.programVersionPersistencePort = programVersionPersistencePort;
    }

    @Override
    public byte[] generateGraduateReportFile(UserFilter filter, ReportFormat format) {
        GraduateReport graduateReport = buildGraduateReport(filter);
        return reportGenerationPort.generateReport(graduateReport, format);
    }

    @Override
    public GraduateReport generateReport(UserFilter filter) {
        return buildGraduateReport(filter);
    }

    private GraduateReport buildGraduateReport(UserFilter filter) {
        List<FullProgramVersion> programVersions = programVersionPersistencePort.findAll();
        Map<Long, FullProgramVersion> programVersionMap = programVersions.stream()
                .collect(Collectors.toMap(FullProgramVersion::getId, Function.identity()));
        List<Long> versionIds = programVersions.stream()
                .filter(version -> Arrays.stream(filter.getProgramIds()).anyMatch(version.getProgram().getId()::equals))
                .map(FullProgramVersion::getId)
                .toList();
        filter.setProgramVersionIds(versionIds);
        filter.setRole(RoleName.GRADUATE);

        String programName = programVersions.stream()
                .findFirst()
                .filter(version -> Arrays.stream(filter.getProgramIds()).anyMatch(version.getProgram().getId()::equals))
                .map(p -> p.getProgram().getName())
                .orElse(ALL_STRING);

        List<FullUser> fullUsers = userPersistencePort.findAllFilteredForReport(filter);

        List<FullUser> enrichedFullUser = fullUsers.stream()
                .map(enrichFullUser(programVersionMap))
                .toList();

        List<ReportUser> reportDataList = fullUsers.stream()
                .map(ReportHelper::fromFullUser)
                .toList();

        return buildGraduateReportModel(fullUsers, filter, programName, reportDataList);
    }

    private Function<FullUser, FullUser> enrichFullUser(Map<Long, FullProgramVersion> programVersionMap) {
        return user -> {
            List<CoursedProgram> coursedPrograms = user.getCoursedPrograms().stream()
                    .map(mapFullProgramVersionToSimple(programVersionMap)).toList();
            user.setCoursedPrograms(coursedPrograms);
            return user;
        };
    }

    private Function<CoursedProgram, CoursedProgram> mapFullProgramVersionToSimple(
            Map<Long, FullProgramVersion> programVersionMap) {
        return program -> {
            FullProgramVersion version = programVersionMap.getOrDefault(program.getProgramVersion().getId(), null);
            program.setProgramVersion(
                    ProgramVersion.builder()
                            .id(version.getId())
                            .name(version.getProgram().getName())
                            .version(version.getVersion())
                            .build());
            return program;
        };
    }

    private GraduateReport buildGraduateReportModel(
            List<FullUser> users,
            UserFilter filter,
            String program,
            List<ReportUser> dataList) {
        final long total = users.size();
        Map<Gender, Long> genderCounts = users.stream()
                .filter(u -> u.getGender() != null)
                .collect(Collectors.groupingBy(FullUser::getGender, Collectors.counting()));

        final Long woman = genderCounts.getOrDefault(Gender.FEMALE, DEFAULT_COUNT_VALUE);
        final Long man = genderCounts.getOrDefault(Gender.MALE, DEFAULT_COUNT_VALUE);
        final Long nonBinary = genderCounts.getOrDefault(Gender.NON_BINARY, DEFAULT_COUNT_VALUE);
        final Long other = genderCounts.getOrDefault(Gender.OTHER, DEFAULT_COUNT_VALUE);

        return GraduateReport.builder()
                .users(dataList)
                .program(program)
                .gender(Optional.ofNullable(filter.getGender()).map(Enum::name).orElse(ALL_STRING))
                .country(filter.getCountry())
                .state(filter.getState())
                .city(filter.getCity())
                .totalGraduates(total)
                .womanCount(woman)
                .manCount(man)
                .nonBinaryCount(nonBinary)
                .otherCount(other)
                .womanPercentage(percentage(woman, total))
                .manPercentage(percentage(man, total))
                .nonBinaryPercentage(percentage(nonBinary, total))
                .otherPercentage(percentage(other, total))
                .startYear(filter.getStartYear())
                .endYear(filter.getEndYear())
                .build();
    }

    private double percentage(long count, long total) {
        if (total <= ZERO)
            return ZERO_PERCENTAGE;
        return BigDecimal.valueOf(count)
                .multiply(BigDecimal.valueOf(ONE_HUNDRED))
                .divide(BigDecimal.valueOf(total), DEFAULT_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
