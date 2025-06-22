package co.edu.udea.nexum.profile.coursed_program.infrastructure.utils.constants;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoursedProgramRestConstants {
    // Controller data
    public static final String COURSED_PROGRAM_CONTROLLER_PATH = "/v1/coursed-programs";
    public static final String COURSED_PROGRAM_CONTROLLER_NAME = "Programa Cursado";
    public static final String COURSED_PROGRAM_CONTROLLER_DESCRIPTION = "Cualquier operación relacionada a los Programas Cursados por los usuarios";

    // Save
    public static final String SWAGGER_SAVE_NEW_COURSED_PROGRAM_SUMMARY = "Guarda un nuevo programa cursado";
    public static final String SWAGGER_NEW_COURSED_PROGRAM_SAVED_SUCCESSFULLY = "El nuevo programa cursado ha sido registrado satisfactoriamente";

    // Find by id
    public static final String SWAGGER_COURSED_PROGRAM_WITH_ID_NOT_FOUND = "No se ha encontrado un programa cursado con ese id";
    public static final String SWAGGER_COURSED_PROGRAM_FOUND = "El programa cursado ha sido encontrado";
    public static final String SWAGGER_FIND_COURSED_PROGRAM_BY_ID_SUMMARY = "Busca un programa cursado por su id";

    // Find all
    public static final String SWAGGER_FIND_ALL_COURSED_PROGRAMS_SUMMARY = "Busca todos los programas cursados registrados";
    public static final String SWAGGER_FIND_ALL_COURSED_PROGRAMS_SUCCESSFULLY = "Retorna una lista con los programas cursados encontrados";

    // Update by id
    public static final String SWAGGER_UPDATE_COURSED_PROGRAM_BY_ID_SUMMARY = "Actualizar completamente un programa cursado";
    public static final String SWAGGER_COURSED_PROGRAM_UPDATED_SUCCESSFULLY = "El programa cursado fue actualizado satisfactoriamente";

    // Delete by id
    public static final String SWAGGER_DELETE_COURSED_PROGRAM_BY_ID_SUMMARY = "Eliminar el programa cursado del id entregado";
    public static final String SWAGGER_COURSED_PROGRAM_DELETED_SUCCESSFULLY = "El programa cursado ha sido eliminado satisfactoriamente";
}