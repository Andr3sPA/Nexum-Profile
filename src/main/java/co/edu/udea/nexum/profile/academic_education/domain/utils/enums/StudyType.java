package co.edu.udea.nexum.profile.academic_education.domain.utils.enums;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;

import static co.edu.udea.nexum.profile.academic_education.domain.utils.constants.AcademicEducationConstants.*;

@Generated
public enum StudyType {
    COURSE(COURSE_NAME),
    DIPLOMA(DIPLOMA_NAME),
    WORKSHOP(WORKSHOP_NAME),
    HACKATHON(HACKATHON_NAME),
    OTHER(OTHER_NAME);

    private final String name;

    StudyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
