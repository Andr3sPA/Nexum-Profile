package co.edu.udea.nexum.profile.job.infrastructure.output.feign.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JobFeignConstants {
    public static final String JOB_AREA_FEIGN_NAME = "JOB-AREA-FEIGN";
    public static final String JOB_AREA_FEIGN_URL = "${nexum.catalog.base_url}/job-areas";

    public static final String JOB_DELAY_FEIGN_NAME = "JOB-DELAY-FEIGN";
    public static final String JOB_DELAY_FEIGN_URL = "${nexum.catalog.base_url}/job-delay";

    public static final String JOB_INSTITUTION_TYPE_FEIGN_NAME = "JOB-INSTITUTION-TYPE-FEIGN";
    public static final String JOB_INSTITUTION_TYPE_FEIGN_URL = "${nexum.catalog.base_url}/job-institution-types";

    public static final String SALARY_RANGE_FEIGN_NAME = "SALARY-RANGE-FEIGN";
    public static final String SALARY_RANGE_FEIGN_URL = "${nexum.catalog.base_url}/salary-ranges";


}
