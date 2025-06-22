package co.edu.udea.nexum.profile.user.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserUseCaseTest {
    public static final UUID USER_ID = UUID.randomUUID();
    public static final Long DOCUMENT_TYPE_ID = 1L;
    public static final String USER_IDENTITY_DOCUMENT = "123456789";
    public static final String USER_NAME = "John";
    public static final String USER_LASTNAME = "Doe";
    public static final DocumentType DOCUMENT_TYPE = DocumentType.CC;

    @Mock
    private UserPersistencePort userPersistencePort;

    @Mock
    private IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    private UUID userId;
    private User user;
    private IdentityDocumentType identityDocumentType;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userId = USER_ID;
        identityDocumentType = new IdentityDocumentType.IdentityDocumentTypeBuilder()
                .id(DOCUMENT_TYPE_ID)
                .documentType(DOCUMENT_TYPE)
                .build();

        user = new User.UserBuilder()
                .id(userId)
                .identityDocument(USER_IDENTITY_DOCUMENT)
                .identityDocumentType(identityDocumentType)
                .name(USER_NAME)
                .lastname(USER_LASTNAME)
                .build();
    }

    @Test
    public void testSaveUser() {
        when(userPersistencePort.save(Mockito.any(User.class))).thenReturn(user);
        when(identityDocumentTypePersistencePort.findById(DOCUMENT_TYPE_ID)).thenReturn(identityDocumentType);

        User savedUser = userUseCase.save(user);

        assertNotNull(savedUser);
        assertEquals(user.getId(), savedUser.getId());
        assertEquals(user.getIdentityDocument(), savedUser.getIdentityDocument());
        assertEquals(user.getIdentityDocumentType(), savedUser.getIdentityDocumentType());

        verify(userPersistencePort, times(1)).save(Mockito.any(User.class));
        verify(identityDocumentTypePersistencePort, times(1)).findById(DOCUMENT_TYPE_ID);
    }

    @Test
    public void testFindAllUsers() {
        when(userPersistencePort.findAll()).thenReturn(List.of(user));

        List<User> users = userUseCase.findAll();

        assertNotNull(users);
    }

    @Test
    public void testFindByIdUser() {
        when(userPersistencePort.findById(userId)).thenReturn(user);
        when(identityDocumentTypePersistencePort.findById(DOCUMENT_TYPE_ID)).thenReturn(identityDocumentType);

        User foundUser = userUseCase.findById(userId);

        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
        assertEquals(user.getIdentityDocument(), foundUser.getIdentityDocument());
        assertEquals(user.getIdentityDocumentType(), foundUser.getIdentityDocumentType());

        verify(userPersistencePort, times(1)).findById(userId);
        verify(identityDocumentTypePersistencePort, times(1)).findById(DOCUMENT_TYPE_ID);
    }

    @Test
    public void testFindByIdUser_notFound() {
        when(userPersistencePort.findById(userId)).thenReturn(null);
        when(identityDocumentTypePersistencePort.findById(DOCUMENT_TYPE_ID)).thenReturn(identityDocumentType);

        assertThrows(EntityNotFoundException.class, () -> userUseCase.findById(userId));
    }

    @Test
    public void testUpdateUser() {
        when(userPersistencePort.update(Mockito.any(User.class))).thenReturn(user);
        when(userPersistencePort.findById(userId)).thenReturn(user);
        when(identityDocumentTypePersistencePort.findById(DOCUMENT_TYPE_ID)).thenReturn(identityDocumentType);

        User updatedUser = userUseCase.updateById(userId, user);

        assertNotNull(updatedUser);
        assertEquals(user.getId(), updatedUser.getId());
        assertEquals(user.getIdentityDocument(), updatedUser.getIdentityDocument());
        assertEquals(user.getIdentityDocumentType(), updatedUser.getIdentityDocumentType());

        verify(userPersistencePort, times(1)).update(Mockito.any(User.class));
        verify(identityDocumentTypePersistencePort, times(2)).findById(DOCUMENT_TYPE_ID);
    }

    @Test
    public void testDeleteUser() {
        when(userPersistencePort.findById(userId)).thenReturn(user);
        doNothing().when(userPersistencePort).deleteById(userId);

        User deletedUser = userUseCase.deleteById(userId);

        assertNotNull(deletedUser);
        assertEquals(user.getId(), deletedUser.getId());

        verify(userPersistencePort, times(1)).findById(userId);
        verify(userPersistencePort, times(1)).deleteById(userId);
    }
}
