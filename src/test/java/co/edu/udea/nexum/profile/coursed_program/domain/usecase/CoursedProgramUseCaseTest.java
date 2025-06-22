package co.edu.udea.nexum.profile.coursed_program.domain.usecase;

import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoursedProgramUseCaseTest {

    // Constantes
    public static final Long COURSE_ID = 1L;
    public static final Long PROGRAM_VERSION_ID = 100L;
    public static final UUID USER_ID = UUID.randomUUID();
    public static final Integer GRADUATION_YEAR = 2023;
    public static final String STRENGTHS = "Strengths Example";
    public static final String WEAKNESSES = "Weaknesses Example";
    public static final String SUGGESTED_COMPETENCIES = "Suggested Competencies Example";
    public static final boolean WHATSAPP_GROUP_MEMBER = true;
    public static final String PROGRAM_NAME = "Program Name";

    @Mock
    private CoursedProgramPersistencePort coursedProgramPersistencePort;

    @Mock
    private ProgramVersionPersistencePort programVersionPersistencePort;

    @Mock
    private UserPersistencePort userPersistencePort;

    @InjectMocks
    private CoursedProgramUseCase coursedProgramUseCase;

    private CoursedProgram coursedProgram;
    private ProgramVersion programVersion;
    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(USER_ID)
                .build();

        programVersion = ProgramVersion.builder()
                .id(PROGRAM_VERSION_ID)
                .name(PROGRAM_NAME)
                .version((short) 1)
                .build();

        coursedProgram = CoursedProgram.builder()
                .id(COURSE_ID)
                .user(user)
                .programVersion(programVersion)
                .graduationYear(GRADUATION_YEAR)
                .strengths(STRENGTHS)
                .weaknesses(WEAKNESSES)
                .suggestedCompetencies(SUGGESTED_COMPETENCIES)
                .whatsappGroupMember(WHATSAPP_GROUP_MEMBER)
                .build();
    }

    @Test
    void save() {
        when(programVersionPersistencePort.findById(PROGRAM_VERSION_ID)).thenReturn(programVersion);
        when(userPersistencePort.existsById(USER_ID)).thenReturn(true);
        when(coursedProgramPersistencePort.save(coursedProgram)).thenReturn(coursedProgram);

        CoursedProgram result = coursedProgramUseCase.save(coursedProgram);

        assertNotNull(result);
        assertEquals(COURSE_ID, result.getId());
        assertEquals(STRENGTHS, result.getStrengths());
        assertEquals(PROGRAM_VERSION_ID, result.getProgramVersion().getId());
        verify(coursedProgramPersistencePort).save(coursedProgram);
    }

    @Test
    void updateById() {
        when(programVersionPersistencePort.findById(PROGRAM_VERSION_ID)).thenReturn(programVersion);
        when(coursedProgramPersistencePort.findById(COURSE_ID)).thenReturn(coursedProgram);
        when(userPersistencePort.existsById(USER_ID)).thenReturn(true);
        when(coursedProgramPersistencePort.update(coursedProgram)).thenReturn(coursedProgram);


        CoursedProgram result = coursedProgramUseCase.updateById(COURSE_ID, coursedProgram);

        assertNotNull(result);
        assertEquals(COURSE_ID, result.getId());
        assertEquals(STRENGTHS, result.getStrengths());
        verify(coursedProgramPersistencePort).update(coursedProgram);
    }

    @Test
    void findById_notFound() {
        when(coursedProgramPersistencePort.findById(COURSE_ID)).thenReturn(null);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> coursedProgramUseCase.findById(COURSE_ID));
    }

    @Test
    void findById_found() {
        when(coursedProgramPersistencePort.findById(COURSE_ID)).thenReturn(coursedProgram);

        CoursedProgram result = coursedProgramUseCase.findById(COURSE_ID);

        assertNotNull(result);
        assertEquals(COURSE_ID, result.getId());
        assertEquals(STRENGTHS, result.getStrengths());
        verify(coursedProgramPersistencePort).findById(COURSE_ID);
    }

    @Test
    void deleteById() {
        when(coursedProgramPersistencePort.findById(COURSE_ID)).thenReturn(coursedProgram);
        doNothing().when(coursedProgramPersistencePort).deleteById(COURSE_ID);

        CoursedProgram result = coursedProgramUseCase.deleteById(COURSE_ID);

        assertNotNull(result);
        assertEquals(COURSE_ID, result.getId());
        verify(coursedProgramPersistencePort).deleteById(COURSE_ID);
    }

    @Test
    void validateEntity_userNotFound() {
        when(userPersistencePort.existsById(USER_ID)).thenReturn(false);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> coursedProgramUseCase.validateEntity(COURSE_ID, coursedProgram));
    }

    @Test
    void validateEntity_userFound() {
        when(userPersistencePort.existsById(USER_ID)).thenReturn(true);

        coursedProgramUseCase.validateEntity(COURSE_ID, coursedProgram);
    }
}
