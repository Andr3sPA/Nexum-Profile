package co.edu.udea.nexum.profile.report.domain.utils.functions;

import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.job.domain.model.Job;
import co.edu.udea.nexum.profile.report.domain.model.ReportUser;
import co.edu.udea.nexum.profile.user.domain.model.full.FullUser;

import java.util.Objects;
import java.util.Optional;

import static co.edu.udea.nexum.profile.report.domain.utils.constants.ReportConstants.*;

public class ReportHelper {

    public static ReportUser fromFullUser(FullUser user) {
        return ReportUser.builder()
                .names(user.getName() + SPACE_STRING + Optional.ofNullable(user.getMiddleName()).orElse(EMPTY_STRING))
                .lastnames(user.getLastname() + SPACE_STRING + Optional.ofNullable(user.getSecondLastname()).orElse(EMPTY_STRING))
                .email(user.getContactInformationList().stream()
                        .filter(ContactInformation::getCurrent)
                        .map(ContactInformation::getEmail)
                        .findFirst()
                        .orElse(N_A_STRING))
                .mobile(user.getContactInformationList().stream()
                        .filter(ContactInformation::getCurrent)
                        .map(ContactInformation::getMobile)
                        .findFirst()
                        .orElse(N_A_STRING))
                .graduateGender(user.getGender() != null ? user.getGender().getName() : N_A_STRING)
                .occupation(user.getJobs().stream()
                        .filter(Job::getCurrentJob)
                        .findFirst()
                        .map(Job::getPosition)
                        .orElse(N_A_STRING))
                .identityDocument(user.getIdentityDocument())
                .program(user.getCoursedPrograms().stream()
                        .findFirst()
                        .map(coursedProgram -> coursedProgram.getProgramVersion().getName())
                        .orElse(N_A_STRING)
                )
                .graduationYear(user.getCoursedPrograms().stream()
                        .map(CoursedProgram::getGraduationYear)
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElse(null))
                .build();
    }
}
