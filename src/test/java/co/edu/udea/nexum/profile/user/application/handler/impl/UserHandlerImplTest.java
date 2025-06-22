package co.edu.udea.nexum.profile.user.application.handler.impl;

import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.application.dto.response.IdentityDocumentTypeResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import co.edu.udea.nexum.profile.user.application.mapper.request.UserRequestMapper;
import co.edu.udea.nexum.profile.user.application.mapper.response.UserResponseMapper;
import co.edu.udea.nexum.profile.user.domain.api.UserServicePort;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserHandlerImplTest {

    private static final UUID USER_ID = UUID.randomUUID();
    private static final String IDENTITY_DOCUMENT = "123456789";
    private static final Long ID_IDENTITY_DOCUMENT_TYPE = 1L;
    private static final IdentityDocumentType IDENTITY_DOCUMENT_TYPE = IdentityDocumentType.builder()
            .id(ID_IDENTITY_DOCUMENT_TYPE)
            .documentType(DocumentType.CC)
            .build();
    private static final IdentityDocumentTypeResponse IDENTITY_DOCUMENT_TYPE_RESPONSE = IdentityDocumentTypeResponse.builder()
            .id(ID_IDENTITY_DOCUMENT_TYPE)
            .name(DocumentType.CC.getName())
            .abbreviation(DocumentType.CC.getAbbreviation())
            .build();
    private static final String NAME = "John";
    private static final String LASTNAME = "Doe";
    private static final LocalDate BIRTHDATE = LocalDate.of(1990, 1, 1);
    private static final String EMAIL = "john.doe@example.com";
    private static final String PHONE = "1234567890";
    private static final String ADDRESS = "123 Main St";
    public static final int EXPECTED_MOCK_SIZE = 1;

    @Mock
    private UserServicePort userServicePort;

    @Mock
    private UserResponseMapper userResponseMapper;

    @Mock
    private UserRequestMapper userRequestMapper;

    @InjectMocks
    private UserHandlerImpl userHandler;

    private User user;
    private UserRequest userRequest;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = User.builder()
                .id(USER_ID)
                .identityDocument(IDENTITY_DOCUMENT)
                .identityDocumentType(IDENTITY_DOCUMENT_TYPE)
                .name(NAME)
                .lastname(LASTNAME)
                .birthdate(BIRTHDATE)
                .email(EMAIL)
                .phone(PHONE)
                .address(ADDRESS)
                .build();

        userRequest = UserRequest.builder()
                .identityDocument(IDENTITY_DOCUMENT)
                .idIdentityDocumentType(ID_IDENTITY_DOCUMENT_TYPE)
                .name(NAME)
                .lastname(LASTNAME)
                .birthdate(BIRTHDATE)
                .email(EMAIL)
                .phone(PHONE)
                .address(ADDRESS)
                .build();

        userResponse = UserResponse.builder()
                .id(USER_ID)
                .identityDocument(IDENTITY_DOCUMENT)
                .identityDocumentType(IDENTITY_DOCUMENT_TYPE_RESPONSE)
                .name(NAME)
                .lastname(LASTNAME)
                .birthdate(BIRTHDATE)
                .email(EMAIL)
                .phone(PHONE)
                .address(ADDRESS)
                .build();
    }

    @Test
    void testSave() {
        when(userRequestMapper.toDomain(userRequest)).thenReturn(user);
        when(userServicePort.save(user)).thenReturn(user);
        when(userResponseMapper.toResponse(user)).thenReturn(userResponse);

        UserResponse result = userHandler.save(userRequest);

        assertEquals(userResponse, result);
        verify(userRequestMapper).toDomain(userRequest);
        verify(userServicePort).save(user);
        verify(userResponseMapper).toResponse(user);
    }

    @Test
    void testFindAll() {

        when(userServicePort.findAll()).thenReturn(List.of(user));
        when(userResponseMapper.toResponses(List.of(user))).thenReturn(List.of(userResponse));

        List<UserResponse> result = userHandler.findAll();

        assertEquals(EXPECTED_MOCK_SIZE, result.size());
        assertEquals(userResponse, result.getFirst());
        verify(userServicePort).findAll();
        verify(userResponseMapper).toResponses(List.of(user));
    }

    @Test
    void testFindById() {
        when(userServicePort.findById(USER_ID)).thenReturn(user);
        when(userResponseMapper.toResponse(user)).thenReturn(userResponse);

        UserResponse result = userHandler.findById(USER_ID);

        assertEquals(userResponse, result);
        verify(userServicePort).findById(USER_ID);
        verify(userResponseMapper).toResponse(user);
    }

    @Test
    void testUpdateById() {
        when(userRequestMapper.toDomain(userRequest)).thenReturn(user);
        when(userServicePort.updateById(USER_ID, user)).thenReturn(user);
        when(userResponseMapper.toResponse(user)).thenReturn(userResponse);

        UserResponse result = userHandler.updateById(USER_ID, userRequest);

        assertEquals(userResponse, result);
        verify(userRequestMapper).toDomain(userRequest);
        verify(userServicePort).updateById(USER_ID, user);
        verify(userResponseMapper).toResponse(user);
    }

    @Test
    void testDeleteById() {
        when(userServicePort.deleteById(USER_ID)).thenReturn(user);
        when(userResponseMapper.toResponse(user)).thenReturn(userResponse);

        UserResponse result = userHandler.deleteById(USER_ID);

        assertEquals(userResponse, result);
        verify(userServicePort).deleteById(USER_ID);
        verify(userResponseMapper).toResponse(user);
    }
}
