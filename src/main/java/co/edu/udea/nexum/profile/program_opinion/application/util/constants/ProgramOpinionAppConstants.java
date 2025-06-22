package co.edu.udea.nexum.profile.program_opinion.application.util.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProgramOpinionAppConstants {
    public static final String COURSED_PROGRAM_ID_NOT_NULL_MESSAGE = "El ID del coursedProgram es obligatorio";
    public static final String STRENGTHS_NOT_BLANK_MESSAGE = "Las fortalezas no pueden estar vacías";
    public static final String WEAKNESSES_NOT_BLANK_MESSAGE = "Las debilidades no pueden estar vacías";
    public static final String SUGGESTED_COMPETENCIES_NOT_EMPTY_MESSAGE = "Debe proporcionar al menos una competencia sugerida";
    public static final String SUGGESTED_COMPETENCY_NOT_BLANK_MESSAGE = "Las competencias sugeridas no pueden estar vacías";
}
