package co.edu.udea.nexum.profile.user.application.dto.response.basic;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BasicUserResponse {
    private UUID id;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private Gender gender;
    private List<BasicProgramResponse> programs;
    private String email;
    private String academicEmail;
    private String mobile;
    private String country;
    private String city;
    private RoleName role;
    private Integer graduationYear;
    private LocalDateTime lastUpdateDate;
    private String company;
}
