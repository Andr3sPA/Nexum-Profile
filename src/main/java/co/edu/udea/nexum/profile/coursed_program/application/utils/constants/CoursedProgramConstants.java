package co.edu.udea.nexum.profile.coursed_program.application.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoursedProgramConstants {
    public static final String USER_ID_FIELD_NOT_NULL_MESSAGE = "Se debe especificar el usuario";
    public static final String PROGRAM_VERSION_ID_FIELD_NOT_NULL_MESSAGE = "Se debe especificar el programa cursado";
    public static final String GRADUATION_YEAR_FIELD_NOT_NULL_MESSAGE = "Se debe ingresar el año de graduación";
    public static final String STRENGTHS_FIELD_NOT_NULL_MESSAGE = "Debe indicar los puntos fuertes de la carrera";
    public static final String WEAKNESSES_FIELD_NOT_NULL_MESSAGE = "Debe indicar los puntos débiles de la carrera";
    public static final String SUGGESTED_COMPETENCIES_FIELD_NOT_NULL_MESSAGE = "Debe indicar las competencias que quisiera que la carrera tuviera";
    public static final String WHATSAPP_GROUP_MEMBER_FIELD_NOT_NULL_MESSAGE = "Es necesario saber si es miembro del grupo de whatsapp";
    public static final String GRADUATION_YEAR_FIELD_POSITIVE_MESSAGE = "El año debe ser un número positivo";
}
