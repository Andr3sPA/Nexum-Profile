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
    public static final String REGISTER_EMPLOYER_PATH = "/register/employer";
    public static final String AUTHENTICATED_USER = "/authenticated-user";
    public static final String GET_AUTH_BY_USER_ID = "/by-user-id/{userId}";

    public static final String SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY = "Registrar un Administrativo";
    public static final String SWAGGER_REGISTER_ADMINISTRATIVE_SUCCESSFULLY = "El usuario Administrativo ha sido registrado";
    public static final String SWAGGER_REGISTER_ADMINISTRATIVE_SUMMARY_EMAIL_OR_ID_ALREADY_EXISTS = "Un usuario con ese correo o documento de identidad ya existe";
    public static final String SWAGGER_REGISTER_GRADUATE_SUMMARY = "Registrar un egresado";
    public static final String SWAGGER_REGISTER_GRADUATE_SUCCESSFULLY = "El egresado ha sido registrado";
    public static final String SWAGGER_REGISTER_EMPLOYER_SUMMARY = "Registrar un empleador";
    public static final String SWAGGER_REGISTER_EMPLOYER_SUCCESSFULLY = "El empleador ha sido registrado";
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
    public static final String GET_AUTH_BY_USER_ID_SUMMARY = "Buscar credencial de autenticación por ID de usuario";
    public static final String GET_AUTH_BY_USER_ID_SUCCESSFULLY = "La credencial fue encontrada correctamente";
    public static final String GET_AUTH_BY_USER_ID_NOT_FOUND = "La credencial no fue encontrada";


    public static final String ACCOUNT_CONTROLLER_PATH = "/v1/accounts";
    public static final String ACCOUNT_CONTROLLER_NAME = "Cuentas";
    public static final String ACCOUNT_CONTROLLER_DESCRIPTION = "Operaciones relacionadas con las credenciales de autenticación";

    public static final String SWAGGER_FIND_AUTH_BY_ID_SUMMARY = "Buscar credencial de autenticación por ID";
    public static final String SWAGGER_FIND_AUTH_SUCCESSFULLY = "La credencial fue encontrada correctamente";
    public static final String SWAGGER_FIND_AUTH_NOT_FOUND = "La credencial no fue encontrada";

    public static final String SWAGGER_UPDATE_AUTH_BY_ID_SUMMARY = "Actualizar credencial de autenticación por ID";
    public static final String SWAGGER_UPDATE_AUTH_SUCCESSFULLY = "La credencial fue actualizada correctamente";
    public static final String SWAGGER_UPDATE_AUTH_NOT_FOUND = "La credencial no fue encontrada";
    public static final String SWAGGER_UPDATE_AUTH_FORBIDDEN = "No tienes permiso para actualizar esta credencial";

    public static final String SWAGGER_FIND_ALL_AUTH_FILTERED_SUMMARY = "Buscar credenciales con filtros";
    public static final String SWAGGER_FIND_ALL_AUTH_SUCCESSFULLY = "Las credenciales fueron encontradas correctamente";


}
