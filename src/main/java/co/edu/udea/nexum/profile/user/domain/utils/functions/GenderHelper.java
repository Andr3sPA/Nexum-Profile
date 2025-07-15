package co.edu.udea.nexum.profile.user.domain.utils.functions;

import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;

import java.util.Arrays;

public class GenderHelper {
    private GenderHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static Gender fromName(String name) {
        return Arrays.stream(Gender.values())
                .filter(g -> g.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant Gender for name: " + name));
    }

}
