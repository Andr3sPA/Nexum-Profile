package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GraduateParticipationFeignConstants {

    public static final String INNOVATION_PROCESS_TYPE_FEIGN_NAME = "INNOVATION-PROCESS-TYPE-FEIGN";
    public static final String INNOVATION_PROCESS_TYPE_FEIGN_URL = "${nexum.catalog.base_url}/innovation-process-types";
    public static final String IDS_PATH = "/ids";

}
