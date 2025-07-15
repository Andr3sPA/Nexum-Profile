package co.edu.udea.nexum.profile.program_opinion.infrastructure.utils.constants;

public class ProgramOpinionRestConstants {

    public static final String PROGRAM_OPINION_CONTROLLER_PATH = "v1/program-opinions";
    public static final String PROGRAM_OPINION_CONTROLLER_NAME = "Opinión acerca del programa cursado";
    public static final String PROGRAM_OPINION_CONTROLLER_DESCRIPTION = "Operaciones relacionadas al registro de la opinión del egresado ante el programa";

    public static final String SWAGGER_SAVE_PROGRAM_OPINION_SUMMARY = "Operación para guardar la opinión del usuario sobre su programa académico";
    public static final String SWAGGER_SAVE_PROGRAM_OPINION_SUCCESSFULLY = "La opinión ha sido creada exitosamente";
    public static final String SWAGGER_SAVE_PROGRAM_OPINION_CAREER_NOT_FOUND = "El usuario no tiene un programa registrado";
    public static final String SWAGGER_SAVE_PROGRAM_OPINION_CAREER_DOESNT_BELONG_TO_USER = "El programa registrado no pertenece al usuario actual";

    public static final String SWAGGER_FIND_PROGRAM_OPINION_BY_ID_SUMMARY = "Operación para obtener la opinión del usuario sobre su programa académico";
    public static final String SWAGGER_FIND_PROGRAM_OPINION_BY_ID_SUCCESSFULLY = "La opinión ha sido encontrada";
    public static final String SWAGGER_FIND_PROGRAM_OPINION_BY_ID_OPINION_DOESNT_EXISTS = "La opinión no existe";

    public static final String SWAGGER_UPDATE_PROGRAM_OPINION_BY_ID_SUMMARY = "Operación para actualizar la opinión del usuario sobre su programa académico";
    public static final String SWAGGER_UPDATE_PROGRAM_OPINION_BY_ID_SUCCESSFULLY = "La opinión ha sido actualizada exitosamente";
    public static final String SWAGGER_UPDATE_PROGRAM_OPINION_BY_ID_OPINION_DOESNT_BELONG_TO_USER = "La opinión no pertenece al usuario actual";
}
