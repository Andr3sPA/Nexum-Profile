package co.edu.udea.nexum.profile.coursed_program.application.handler.impl;

import co.edu.udea.nexum.profile.coursed_program.application.dto.request.CoursedProgramRequest;
import co.edu.udea.nexum.profile.coursed_program.application.dto.response.CoursedProgramResponse;
import co.edu.udea.nexum.profile.coursed_program.application.mapper.request.CoursedProgramRequestMapper;
import co.edu.udea.nexum.profile.coursed_program.application.mapper.response.CoursedProgramResponseMapper;
import co.edu.udea.nexum.profile.coursed_program.domain.api.CoursedProgramServicePort;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoursedProgramHandlerImplTest {

    public static final Long COURSE_ID = 1L;
    public static final Long PROGRAM_VERSION_ID = 100L;
    public static final Integer GRADUATION_YEAR = 2023;
    public static final String STRENGTHS = "Strengths Example";
    public static final String WEAKNESSES = "Weaknesses Example";
    public static final String SUGGESTED_COMPETENCIES = "Suggested Competencies Example";
    public static final boolean WHATSAPP_GROUP_MEMBER = true;
    public static final UUID USER_ID = UUID.randomUUID();

    @Mock
    private CoursedProgramServicePort coursedProgramServicePort;

    @Mock
    private CoursedProgramResponseMapper coursedProgramResponseMapper;

    @Mock
    private CoursedProgramRequestMapper coursedProgramRequestMapper;

    @InjectMocks
    private CoursedProgramHandlerImpl coursedProgramHandler;

    private CoursedProgramRequest coursedProgramRequest;
    private CoursedProgram coursedProgram;
    private CoursedProgramResponse coursedProgramResponse;

    @BeforeEach
    void setUp() {
        coursedProgramRequest = CoursedProgramRequest.builder()
                .userId(USER_ID)
                .programVersionId(PROGRAM_VERSION_ID)
                .graduationYear(GRADUATION_YEAR)
                .strengths(STRENGTHS)
                .weaknesses(WEAKNESSES)
                .suggestedCompetencies(SUGGESTED_COMPETENCIES)
                .whatsappGroupMember(WHATSAPP_GROUP_MEMBER)
                .build();

        coursedProgram = new CoursedProgram.CoursedProgramBuilder()
                .id(COURSE_ID)
                .user(User.builder()
                        .id(USER_ID)
                        .build())
                .programVersion(ProgramVersion.builder()
                        .id(COURSE_ID)
                        .build())
                .graduationYear(GRADUATION_YEAR)
                .strengths(STRENGTHS)
                .weaknesses(WEAKNESSES)
                .suggestedCompetencies(SUGGESTED_COMPETENCIES)
                .whatsappGroupMember(WHATSAPP_GROUP_MEMBER)
                .build();

        coursedProgramResponse = CoursedProgramResponse.builder()
                .id(COURSE_ID)
                .graduationYear(GRADUATION_YEAR)
                .strengths(STRENGTHS)
                .weaknesses(WEAKNESSES)
                .suggestedCompetencies(SUGGESTED_COMPETENCIES)
                .whatsappGroupMember(WHATSAPP_GROUP_MEMBER)
                .build();
    }

    @Test
    void save() {
        when(coursedProgramRequestMapper.toDomain(coursedProgramRequest)).thenReturn(coursedProgram);
        when(coursedProgramServicePort.save(coursedProgram)).thenReturn(coursedProgram);
        when(coursedProgramResponseMapper.toResponse(coursedProgram)).thenReturn(coursedProgramResponse);

        CoursedProgramResponse response = coursedProgramHandler.save(coursedProgramRequest);

        assertNotNull(response);
        assertEquals(COURSE_ID, response.getId());
        assertEquals(STRENGTHS, response.getStrengths());
        verify(coursedProgramRequestMapper).toDomain(coursedProgramRequest);
        verify(coursedProgramServicePort).save(coursedProgram);
        verify(coursedProgramResponseMapper).toResponse(coursedProgram);
    }

    @Test
    void findAll() {
        when(coursedProgramServicePort.findAll()).thenReturn(Collections.singletonList(coursedProgram));
        when(coursedProgramResponseMapper.toResponses(Collections.singletonList(coursedProgram)))
                .thenReturn(Collections.singletonList(coursedProgramResponse));

        List<CoursedProgramResponse> responseList = coursedProgramHandler.findAll();

        assertNotNull(responseList);
        assertFalse(responseList.isEmpty());
        assertEquals(1, responseList.size());
        verify(coursedProgramServicePort).findAll();
        verify(coursedProgramResponseMapper).toResponses(Collections.singletonList(coursedProgram));
    }

    @Test
    void findById() {
        when(coursedProgramServicePort.findById(COURSE_ID)).thenReturn(coursedProgram);
        when(coursedProgramResponseMapper.toResponse(coursedProgram)).thenReturn(coursedProgramResponse);

        CoursedProgramResponse response = coursedProgramHandler.findById(COURSE_ID);

        assertNotNull(response);
        assertEquals(COURSE_ID, response.getId());
        verify(coursedProgramServicePort).findById(COURSE_ID);
        verify(coursedProgramResponseMapper).toResponse(coursedProgram);
    }

    @Test
    void updateById() {
        when(coursedProgramRequestMapper.toDomain(coursedProgramRequest)).thenReturn(coursedProgram);
        when(coursedProgramServicePort.updateById(COURSE_ID, coursedProgram)).thenReturn(coursedProgram);
        when(coursedProgramResponseMapper.toResponse(coursedProgram)).thenReturn(coursedProgramResponse);

        CoursedProgramResponse response = coursedProgramHandler.updateById(COURSE_ID, coursedProgramRequest);

        assertNotNull(response);
        assertEquals(COURSE_ID, response.getId());
        verify(coursedProgramRequestMapper).toDomain(coursedProgramRequest);
        verify(coursedProgramServicePort).updateById(COURSE_ID, coursedProgram);
        verify(coursedProgramResponseMapper).toResponse(coursedProgram);
    }

    @Test
    void deleteById() {
        when(coursedProgramServicePort.deleteById(COURSE_ID)).thenReturn(coursedProgram);
        when(coursedProgramResponseMapper.toResponse(coursedProgram)).thenReturn(coursedProgramResponse);

        CoursedProgramResponse response = coursedProgramHandler.deleteById(COURSE_ID);

        assertNotNull(response);
        assertEquals(COURSE_ID, response.getId());
        verify(coursedProgramServicePort).deleteById(COURSE_ID);
        verify(coursedProgramResponseMapper).toResponse(coursedProgram);
    }
}
