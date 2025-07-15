package co.edu.udea.nexum.profile.contact_information.infrastructure.utils.constants;

public class ContactInformationRestConstants {
    public static final String CONTACT_INFORMATION_CONTROLLER_PATH = "/v1/contact-information";
    public static final String CONTACT_INFORMATION_CONTROLLER_NAME = "Información de contacto";
    public static final String CONTACT_INFORMATION_CONTROLLER_DESCRIPTION = "Operaciones relacionadas con la información de contacto del egresado";

    public static final String SWAGGER_SAVE_CONTACT_INFORMATION_SUMMARY = "Guardar información de contacto";
    public static final String SWAGGER_SAVE_CONTACT_INFORMATION_SUCCESSFULLY = "La información de contacto fue guardada correctamente";
    public static final String SWAGGER_SAVE_CONTACT_INFORMATION_FORBIDDEN = "No tienes permiso para guardar esta información";

    public static final String SWAGGER_FIND_CONTACT_INFORMATION_BY_ID_SUMMARY = "Buscar información de contacto por ID";
    public static final String SWAGGER_FIND_CONTACT_INFORMATION_SUCCESSFULLY = "La información de contacto fue encontrada correctamente";
    public static final String SWAGGER_FIND_CONTACT_INFORMATION_NOT_FOUND = "La información de contacto no fue encontrada";

    public static final String SWAGGER_UPDATE_CONTACT_INFORMATION_BY_ID_SUMMARY = "Actualizar información de contacto por ID";
    public static final String SWAGGER_UPDATE_CONTACT_INFORMATION_SUCCESSFULLY = "La información de contacto fue actualizada correctamente";
    public static final String SWAGGER_UPDATE_CONTACT_INFORMATION_NOT_FOUND = "La información de contacto no fue encontrada";
    public static final String SWAGGER_UPDATE_CONTACT_INFORMATION_FORBIDDEN = "No tienes permiso para actualizar esta información";

    public static final String SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_BY_USER_ID_SUMMARY = "Buscar información de contacto actual por ID de usuario";
    public static final String SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_SUCCESSFULLY = "La información de contacto actual fue encontrada correctamente";
    public static final String SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_NOT_FOUND = "La información de contacto actual no fue encontrada";
    public static final String SWAGGER_FIND_CURRENT_CONTACT_INFORMATION_FORBIDDEN = "No tienes permiso para acceder a esta información";

    public static final String CURRENT_BY_USER_ID_PATH = "/current";
}
