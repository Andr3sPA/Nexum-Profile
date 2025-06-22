package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.mapper.UserEntityMapper;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class UserJpaAdapterTest {

    private static final UUID USER_ID = UUID.randomUUID();
    private static final String IDENTITY_DOCUMENT = "1234567890";
    private static final Long ID_IDENTITY_DOCUMENT_TYPE = 1L;
    private static final IdentityDocumentType IDENTITY_DOCUMENT_TYPE = IdentityDocumentType.builder()
            .id(ID_IDENTITY_DOCUMENT_TYPE)
            .documentType(DocumentType.CC)
            .build();
    private static final String NAME = "John";
    private static final String LASTNAME = "Doe";
    private static final LocalDate BIRTHDATE = LocalDate.of(1990, 1, 1);
    private static final String EMAIL = "john.doe@example.com";
    private static final String PHONE = "123456789";
    private static final String ADDRESS = "123 Main St";
    public static final int EXPECTED_FIND_ALL_SIZE = 1;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @InjectMocks
    private UserJpaAdapter userJpaAdapter;

    private User user;
    private UserEntity userEntity;

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

        userEntity = UserEntity.builder()
                .id(USER_ID)
                .identityDocument(IDENTITY_DOCUMENT)
                .idIdentityDocumentType(ID_IDENTITY_DOCUMENT_TYPE)
                .name(NAME)
                .lastname(LASTNAME)
                .birthdate(BIRTHDATE)
                .email(EMAIL)
                .phone(PHONE)
                .address(ADDRESS)
                .build();
    }

    @Test
    void shouldSaveUserSuccessfully() {
        when(userEntityMapper.toEntity(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userEntityMapper.toDomain(userEntity)).thenReturn(user);

        User savedUser = userJpaAdapter.save(user);

        assertThat(savedUser).isEqualTo(user);

        verify(userEntityMapper).toEntity(user);
        verify(userRepository).save(userEntity);
        verify(userEntityMapper).toDomain(userEntity);
    }

    @Test
    void shouldFindUserByIdSuccessfully() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toDomain(userEntity)).thenReturn(user);

        User foundUser = userJpaAdapter.findById(USER_ID);

        assertThat(foundUser).isEqualTo(user);

        verify(userRepository).findById(USER_ID);
        verify(userEntityMapper).toDomain(userEntity);
    }

    @Test
    void shouldFindAllUsersSuccessfully() {
        when(userRepository.findAll()).thenReturn(List.of(userEntity));
        when(userEntityMapper.toDomains(List.of(userEntity))).thenReturn(List.of(user));

        List<User> users = userJpaAdapter.findAll();

        assertThat(users).hasSize(EXPECTED_FIND_ALL_SIZE).containsExactly(user);

        verify(userRepository).findAll();
        verify(userEntityMapper).toDomains(List.of(userEntity));
    }

    @Test
    void shouldUpdateUserSuccessfully() {
        when(userEntityMapper.toEntity(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userEntityMapper.toDomain(userEntity)).thenReturn(user);

        User updatedUser = userJpaAdapter.update(user);

        assertThat(updatedUser).isEqualTo(user);

        verify(userEntityMapper).toEntity(user);
        verify(userRepository).save(userEntity);
        verify(userEntityMapper).toDomain(userEntity);
    }

    @Test
    void shouldDeleteUserByIdSuccessfully() {
        doNothing().when(userRepository).deleteById(USER_ID);

        userJpaAdapter.deleteById(USER_ID);

        verify(userRepository).deleteById(USER_ID);
    }
}
