package co.edu.udea.nexum.profile.auth.infrastructure.utils.constants;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthRestConstants {

    public static final String AUTH_PATH = "/v1/auth";
    public static final String AUTH_CONTROLLER_NAME = "Autenticación";
    public static final String AUTH_CONTROLLER_DESCRIPTION = "Operaciones relacionadas con el registro y la autenticación de los usuarios";

    public static final String LOGIN_PATH = "/login";
    public static final String VALIDATE_PATH = "/validate";
    public static final String GET_USER_BY_TOKEN_PATH = "/user";
    public static final String REGISTER_ADMINISTRATIVE_PATH = "/register/administrative";
    public static final String REGISTER_GRADUATE_PATH = "/register/graduate";
    public static final String AUTHENTICATED_USER = "/authenticated-user";

    public static final String SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY = "Registrar un Administrativo";
    public static final String SWAGGER_REGISTER_ADMINISTRATIVE_SUCCESSFULLY = "El usuario Administrativo ha sido registrado";
    public static final String SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY_EMAIL_OR_ID_ALREADY_EXISTS = "Un usuario con ese correo o documento de identidad ya existe";
    public static final String SWAGGER_REGISTER_GRADUATE_SUMMARY = "Registrar un egresado";
    public static final String SWAGGER_REGISTER_GRADUATE_SUCCESSFULLY = "El egresado ha sido registrado";
    public static final String SWAGGER_LOGIN_SUMMARY = "Inicio de sesión";
    public static final String SWAGGER_LOGIN_SUCCESSFULLY = "Las credenciales han sido aceptadas";
    public static final String SWAGGER_LOGIN_BAD_CREDENTIALS = "Las credenciales están erroneas";
    public static final String SWAGGER_VALIDATE_TOKEN_SUMMARY = "Valida el token";
    public static final String SWAGGER_VALIDATE_TOKEN_SUCCESSFULLY = "El token ha sido validado";
    public static final String SWAGGER_VALIDATE_TOKEN_UNAUTHORIZED = "El token no pudo ser validado";
    public static final String SWAGGER_FIND_USER_BY_TOKEN_SUMMARY = "Busca el Usuario desde el token";
    public static final String SWAGGER_FIND_USER_BY_TOKEN_SUCCESSFULLY = "El token es valido, y el usuario es retornado";
    public static final String SWAGGER_FIND_USER_BY_TOKEN_UNAUTHORIZED = "El token no es válido";
    public static final String GET_AUTHENTICATED_USER_SUMMARY = "Retorna el usuario autenticado actual";
    public static final String GET_AUTHENTICATED_USER_SUCCESSFULLY_MESSAGE = "El usuario ha sido autenticado";
}
