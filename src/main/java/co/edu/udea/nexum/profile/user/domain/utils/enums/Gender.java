package co.edu.udea.nexum.profile.user.domain.utils.enums;

import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.*;

public enum Gender {
    MALE(MALE_NAME, MALE_ABBREVIATION),
    FEMALE(FEMALE_NAME, FEMALE_ABBREVIATION),
    NON_BINARY(NON_BINARY_NAME, NON_BINARY_ABBREVIATION),
    OTHER(OTHER_NAME, OTHER_ABBREVIATION);

    private final String name;
    private final String abbreviation;

    Gender(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}