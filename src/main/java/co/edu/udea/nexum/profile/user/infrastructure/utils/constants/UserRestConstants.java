package co.edu.udea.nexum.profile.user.infrastructure.utils.constants;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRestConstants {
    // Controller data
    public static final String USER_CONTROLLER_PATH = "/v1/users";
    public static final String USER_CONTROLLER_NAME = "Usuario";

    // Save
    public static final String USER_CONTROLLER_DESCRIPTION = "Cualquier operación relacionada a los Usuarios";

    // Find by id
    public static final String SWAGGER_USER_WITH_ID_NOT_FOUND = "No se ha encontrado un usuario con ese id";
    public static final String SWAGGER_USER_FOUND = "El usuario ha sido encontrado";
    public static final String SWAGGER_FIND_USER_BY_ID_SUMMARY = "Busca un usuario por su id";

    // Find all
    public static final String SWAGGER_FIND_ALL_USERS_SUMMARY = "Busca todos los usuarios registrados";
    public static final String SWAGGER_FIND_ALL_USERS_SUCCESSFULLY = "Retorna una lista con los usuarios encontrados";

    // Update by id
    public static final String SWAGGER_UPDATE_USER_BY_ID_SUMMARY = "Actualizar completamente un usuario";
    public static final String SWAGGER_USER_UPDATED_SUCCESSFULLY = "El usuario fue actualizado satisfactoriamente";

    // Delete by id
    public static final String SWAGGER_DELETE_USER_BY_ID_SUMMARY = "Eliminar el usuario del id entregado";
    public static final String SWAGGER_USER_DELETED_SUCCESSFULLY = "El usuario ha sido eliminado satisfactoriamente";
}
