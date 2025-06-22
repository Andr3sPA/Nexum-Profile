package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity.CoursedProgramEntity;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.mapper.CoursedProgramEntityMapper;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.repository.CoursedProgramRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CoursedProgramJpaAdapterTest {

    @Mock
    private CoursedProgramRepository coursedProgramRepository;

    @Mock
    private CoursedProgramEntityMapper coursedProgramEntityMapper;

    @InjectMocks
    private CoursedProgramJpaAdapter coursedProgramJpaAdapter;

    private static final Long COURSE_ID = 1L;
    private static final Long PROGRAM_VERSION_ID = 2L;
    private static final Integer GRADUATION_YEAR = 2024;
    private static final String STRENGTHS = "Strong";
    private static final String WEAKNESSES = "Weak";
    private static final String SUGGESTED_COMPETENCIES = "Competencies";
    private static final boolean WHATSAPP_GROUP_MEMBER = true;

    private CoursedProgram coursedProgram;
    private CoursedProgramEntity coursedProgramEntity;

    @BeforeEach
    void setUp() {
        coursedProgram = new CoursedProgram.CoursedProgramBuilder()
                .id(COURSE_ID)
                .graduationYear(GRADUATION_YEAR)
                .strengths(STRENGTHS)
                .weaknesses(WEAKNESSES)
                .suggestedCompetencies(SUGGESTED_COMPETENCIES)
                .whatsappGroupMember(WHATSAPP_GROUP_MEMBER)
                .build();

        coursedProgramEntity = new CoursedProgramEntity();
        coursedProgramEntity.setId(COURSE_ID);
        coursedProgramEntity.setProgramVersionId(PROGRAM_VERSION_ID);
        coursedProgramEntity.setGraduationYear(GRADUATION_YEAR);
        coursedProgramEntity.setStrengths(STRENGTHS);
        coursedProgramEntity.setWeaknesses(WEAKNESSES);
        coursedProgramEntity.setSuggestedCompetencies(SUGGESTED_COMPETENCIES);
        coursedProgramEntity.setWhatsappGroupMember(WHATSAPP_GROUP_MEMBER);
    }

    @Test
    void testSave() {
        when(coursedProgramEntityMapper.toEntity(coursedProgram)).thenReturn(coursedProgramEntity);
        when(coursedProgramRepository.save(coursedProgramEntity)).thenReturn(coursedProgramEntity);
        when(coursedProgramEntityMapper.toDomain(coursedProgramEntity)).thenReturn(coursedProgram);

        CoursedProgram saved = coursedProgramJpaAdapter.save(coursedProgram);

        assertNotNull(saved);
        assertEquals(COURSE_ID, saved.getId());
        verify(coursedProgramRepository, times(1)).save(coursedProgramEntity);
    }

    @Test
    void testFindById() {
        when(coursedProgramRepository.findById(COURSE_ID)).thenReturn(java.util.Optional.of(coursedProgramEntity));
        when(coursedProgramEntityMapper.toDomain(coursedProgramEntity)).thenReturn(coursedProgram);

        CoursedProgram found = coursedProgramJpaAdapter.findById(COURSE_ID);

        assertNotNull(found);
        assertEquals(COURSE_ID, found.getId());
        verify(coursedProgramRepository, times(1)).findById(COURSE_ID);
    }

    @Test
    void testUpdate() {
        when(coursedProgramEntityMapper.toEntity(coursedProgram)).thenReturn(coursedProgramEntity);
        when(coursedProgramRepository.save(coursedProgramEntity)).thenReturn(coursedProgramEntity);
        when(coursedProgramEntityMapper.toDomain(coursedProgramEntity)).thenReturn(coursedProgram);

        CoursedProgram updated = coursedProgramJpaAdapter.update(coursedProgram);

        assertNotNull(updated);
        assertEquals(COURSE_ID, updated.getId());
        verify(coursedProgramRepository, times(1)).save(coursedProgramEntity);
    }

    @Test
    void testDeleteById() {
        coursedProgramJpaAdapter.deleteById(COURSE_ID);
        verify(coursedProgramRepository, times(1)).deleteById(COURSE_ID);
    }

    @Test
    void testFindAll() {
        when(coursedProgramRepository.findAll()).thenReturn(java.util.List.of(coursedProgramEntity));
        when(coursedProgramEntityMapper.toDomains(java.util.List.of(coursedProgramEntity)))
                .thenReturn(java.util.List.of(coursedProgram));

        var result = coursedProgramJpaAdapter.findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(coursedProgramRepository, times(1)).findAll();
    }
}
