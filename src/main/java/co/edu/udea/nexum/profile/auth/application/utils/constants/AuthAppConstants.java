package co.edu.udea.nexum.profile.auth.application.utils.constants;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthAppConstants {
    public static final String AUTH_EMAIL_FIELD_NOT_NULL_MESSAGE = "el correo no puede ser nulo";
    public static final String AUTH_EMAIL_FIELD_INVALID_FORMAT_MESSAGE = "el correo tiene un formato inválido";
    public static final String AUTH_DOCUMENT_FIELD_INVALID_FORMAT_MESSAGE = "El documento de identidad tiene un formato invalido";
    public static final String AUTH_PASSWORD_FIELD_NOT_NULL_MESSAGE = "La contraseña no puede ser nula";
}
