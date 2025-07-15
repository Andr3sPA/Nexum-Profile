package co.edu.udea.nexum.profile.user.domain.utils.functions;

import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.aggregate.*;

import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;
import co.edu.udea.nexum.profile.job.domain.model.Job;

import java.util.List;
import java.util.stream.Collectors;

public class DetailedUserMapper {

    public static DetailedUser toDetailedUser(
            User user,
            ContactInformation contactInfo,
            FamilyInformation familyInfo,
            GraduateParticipation participation,
            List<Job> jobs,
            List<CoursedProgram> coursedPrograms,
            List<AcademicEducation> academicEducationList,
            List<InnovationProcess> innovationProcesses) {
        return DetailedUser.builder()
                .id(user.getId())
                .identityDocument(user.getIdentityDocument())
                .identityDocumentType(user.getIdentityDocumentType())
                .name(user.getName())
                .middleName(user.getMiddleName())
                .lastname(user.getLastname())
                .secondLastname(user.getSecondLastname())
                .institutionalEmail(user.getInstitutionalEmail())
                .gender(user.getGender())
                .birthdate(user.getBirthdate())
                .contactInformation(toDetailedContactInformation(contactInfo))
                .familyInformation(toDetailedFamilyInformation(familyInfo))
                .graduateParticipation(toDetailedGraduateParticipation(participation))
                .jobs(toDetailedJobs(jobs))
                .coursedPrograms(toDetailedCoursedPrograms(coursedPrograms))
                .academicEducationList(toDetailedAcademicEducationList(academicEducationList))
                .innovationProcesses(toDetailedInnovationProcesses(innovationProcesses))
                .build();
    }

    private static List<DetailedInnovationProcess> toDetailedInnovationProcesses(List<InnovationProcess> innovationProcesses) {
        return innovationProcesses.stream().map(innovationProcess -> DetailedInnovationProcess.builder()
                .id(innovationProcess.getId())
                .name(innovationProcess.getName())
                .description(innovationProcess.getDescription())
                .type(innovationProcess.getType())
                .link(innovationProcess.getLink())
                .creationDate(innovationProcess.getCreationDate())
                .lastUpdate(innovationProcess.getLastUpdate())
                .build()).toList();
    }

    private static DetailedContactInformation toDetailedContactInformation(ContactInformation info) {
        if (info == null) return null;
        return DetailedContactInformation.builder()
                .id(info.getId())
                .address(info.getAddress())
                .country(info.getCountry())
                .state(info.getState())
                .city(info.getCity())
                .landline(info.getLandline())
                .mobile(info.getMobile())
                .email(info.getEmail())
                .academicEmail(info.getAcademicEmail())
                .whatsappAuthorization(info.getWhatsappAuthorization())
                .current(info.getCurrent())
                .build();
    }

    private static DetailedFamilyInformation toDetailedFamilyInformation(FamilyInformation info) {
        if (info == null) return null;
        return DetailedFamilyInformation.builder()
                .id(info.getId())
                .maritalState(info.getMaritalState())
                .childNumber(info.getChildNumber())
                .creationDate(info.getCreationDate())
                .lastUpdate(info.getLastUpdate())
                .build();
    }

    private static DetailedGraduateParticipation toDetailedGraduateParticipation(GraduateParticipation gp) {
        if (gp == null) return null;
        return DetailedGraduateParticipation.builder()
                .id(gp.getId())
                .continuousEducationInterests(gp.getContinuousEducationInterests())
                .willingToBeSpeaker(gp.getWillingToBeSpeaker())
                .willingToBeProfessor(gp.getWillingToBeProfessor())
                .willingToTeachNonFormalEducation(gp.getWillingToTeachNonFormalEducation())
                .willingToBePostgraduateStudent(gp.getWillingToBePostgraduateStudent())
                .willingToBeNonFormalStudent(gp.getWillingToBeNonFormalStudent())
                .willingToBeGraduateRepresentative(gp.getWillingToBeGraduateRepresentative())
                .willingToAttendAlumniMeetings(gp.getWillingToAttendAlumniMeetings())
                .willingToParticipateInAlumniActivities(gp.getWillingToParticipateInAlumniActivities())
                .creationDate(gp.getCreationDate())
                .lastUpdate(gp.getLastUpdate())
                .build();
    }

    private static List<DetailedJob> toDetailedJobs(List<Job> jobs) {
        return jobs.stream().map(job -> DetailedJob.builder()
                .id(job.getId())
                .companyName(job.getCompanyName())
                .country(job.getCountry())
                .position(job.getPosition())
                .relatedToProgram(job.getRelatedToProgram())
                .salaryRange(job.getSalaryRange())
                .jobDelay(job.getJobDelay())
                .jobArea(job.getJobArea())
                .institutionType(job.getInstitutionType())
                .firstJob(job.getFirstJob())
                .currentJob(job.getCurrentJob())
                .creationDate(job.getCreationDate())
                .lastUpdate(job.getLastUpdate())
                .build()).collect(Collectors.toList());
    }

    private static List<DetailedCoursedProgram> toDetailedCoursedPrograms(List<CoursedProgram> programs) {
        return programs.stream().map(cp -> DetailedCoursedProgram.builder()
                .id(cp.getId())
                .programVersion(cp.getProgramVersion())
                .graduationYear(cp.getGraduationYear())
                .strengths(cp.getStrengths())
                .weaknesses(cp.getWeaknesses())
                .improvementSuggestions(cp.getImprovementSuggestions())
                .build()).collect(Collectors.toList());
    }

    private static List<DetailedAcademicEducation> toDetailedAcademicEducationList(List<AcademicEducation> educations) {
        return educations.stream().map(ed -> DetailedAcademicEducation.builder()
                .id(ed.getId())
                .type(ed.getType())
                .studyName(ed.getStudyName())
                .institution(ed.getInstitution())
                .country(ed.getCountry())
                .creationDate(ed.getCreationDate())
                .lastUpdate(ed.getLastUpdate())
                .build()).collect(Collectors.toList());
    }
}
