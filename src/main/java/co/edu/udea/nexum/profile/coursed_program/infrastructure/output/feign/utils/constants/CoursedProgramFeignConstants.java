package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoursedProgramFeignConstants {
    public static final String PROGRAM_VERSION_FEIGN_NAME = "PROGRAM-VERSION-FEIGN";
    public static final String PROGRAM_VERSION_FEIGN_URL = "${nexum.catalog.base_url}/program-versions";
}
