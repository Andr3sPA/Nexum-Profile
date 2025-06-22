package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.client.ProgramVersionFeign;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.dto.response.ProgramFeignResponse;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.mapper.ProgramVersionFeignResponseMapper;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.dto.response.ProgramVersionFeignResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProgramVersionFeignAdapterTest {

    private static final Long PROGRAM_VERSION_ID = 1L;
    private static final String PROGRAM_NAME = "Test Program";
    private static final String SNIES_CODE = "SNIES123";
    private static final short VERSION = 1;
    private static final int START_YEAR = 2020;
    private static final int END_YEAR = 2024;

    @Mock
    private ProgramVersionFeign programVersionFeign;

    @Mock
    private ProgramVersionFeignResponseMapper programVersionFeignResponseMapper;

    @InjectMocks
    private ProgramVersionFeignAdapter programVersionFeignAdapter;

    private ProgramVersionFeignResponse mockFeignResponse;
    private ProgramVersion mockProgramVersion;

    @BeforeEach
    void setUp() {
        mockFeignResponse = ProgramVersionFeignResponse.builder()
                .id(PROGRAM_VERSION_ID)
                .program(ProgramFeignResponse.builder()
                        .id(PROGRAM_VERSION_ID)
                        .name(PROGRAM_NAME)
                        .sniesCode(SNIES_CODE)
                        .build())
                .version(VERSION)
                .startYear(START_YEAR)
                .endYear(END_YEAR)
                .build();

        mockProgramVersion = ProgramVersion.builder()
                .id(PROGRAM_VERSION_ID)
                .name(PROGRAM_NAME)
                .version(VERSION)
                .build();
    }

    @Test
    void testFindById() {
        when(programVersionFeign.findById(PROGRAM_VERSION_ID)).thenReturn(mockFeignResponse);
        when(programVersionFeignResponseMapper.toDomain(mockFeignResponse)).thenReturn(mockProgramVersion);

        ProgramVersion result = programVersionFeignAdapter.findById(PROGRAM_VERSION_ID);

        assertNotNull(result);
        assertEquals(PROGRAM_VERSION_ID, result.getId());
        assertEquals(PROGRAM_NAME, result.getName());
        assertEquals(VERSION, result.getVersion());
    }
}
