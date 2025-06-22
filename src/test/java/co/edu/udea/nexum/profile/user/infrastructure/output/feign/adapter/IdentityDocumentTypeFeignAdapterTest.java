package co.edu.udea.nexum.profile.user.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType;
import co.edu.udea.nexum.profile.user.infrastructure.output.feign.client.IdentityDocumentTypeFeign;
import co.edu.udea.nexum.profile.user.infrastructure.output.feign.dto.response.IdentityDocumentTypeFeignResponse;
import co.edu.udea.nexum.profile.user.infrastructure.output.feign.mapper.response.IdentityDocumentTypeResponseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IdentityDocumentTypeFeignAdapterTest {

    @Mock
    private IdentityDocumentTypeFeign identityDocumentTypeFeign;

    @Mock
    private IdentityDocumentTypeResponseMapper identityDocumentTypeResponseMapper;

    @InjectMocks
    private IdentityDocumentTypeFeignAdapter identityDocumentTypeFeignAdapter;

    private static final Long DOCUMENT_TYPE_ID = 1L;
    public static final String DOCUMENT_NAME = "Cédula";
    private IdentityDocumentType identityDocumentType;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        identityDocumentType = new IdentityDocumentType.IdentityDocumentTypeBuilder()
                .id(DOCUMENT_TYPE_ID)
                .documentType(DocumentType.CC)
                .build();
    }

    @Test
    public void testFindById() {
        when(identityDocumentTypeFeign.getIdentityTypeById(DOCUMENT_TYPE_ID))
                .thenReturn(IdentityDocumentTypeFeignResponse.builder()
                        .id(DOCUMENT_TYPE_ID)
                        .name(DOCUMENT_NAME)
                        .build());
        when(identityDocumentTypeResponseMapper.toDomain(any()))
                .thenReturn(identityDocumentType);

        IdentityDocumentType result = identityDocumentTypeFeignAdapter.findById(DOCUMENT_TYPE_ID);

        assertNotNull(result);
        assertEquals(DOCUMENT_TYPE_ID, result.getId());
        assertEquals(DocumentType.CC, result.getDocumentType());

        verify(identityDocumentTypeFeign, times(1)).getIdentityTypeById(DOCUMENT_TYPE_ID);
        verify(identityDocumentTypeResponseMapper, times(1)).toDomain(any());
    }
}
