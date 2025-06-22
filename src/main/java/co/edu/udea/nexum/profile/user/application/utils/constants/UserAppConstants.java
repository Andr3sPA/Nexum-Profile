package co.edu.udea.nexum.profile.user.application.utils.constants;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;

@Generated
public class UserAppConstants {
    public static final String DOCUMENT_TYPE_FIELD_NOT_NULL_MESSAGE = "El tipo de documento debe ser seleccionado";
    public static final String DOCUMENT_TYPE_MUST_BE_POSITIVE_MESSAGE = "El id del tipo de documento debe ser un número positivo";
    public static final String NAME_FIELD_NOT_NULL_MESSAGE = "el nombre no puede estar vacio";
    public static final String LASTNAME_FIELD_NOT_NULL_MESSAGE = "el primer apellido no puede estar vacio";
    public static final String SECOND_LASTNAME_FIELD_NOT_NULL_MESSAGE = "el segundo apellido no puede estar vacio";
    public static final String BIRTHDATE_FIELD_NOT_NULL_MESSAGE = "la fecha de nacimiento no puede estar vacia";
    public static final String BIRTHDATE_MUST_BE_PAST_MESSAGE = "la fecha debe ser una pasada";
    public static final String DOCUMENT_FIELD_NOT_NULL_MESSAGE = "El documento de identidad no puede estar vacio";
    public static final String DOCUMENT_FIELD_INVALID_FORMAT_MESSAGE = "El documento de identidad tiene un formato invalido";
    public static final String GENDER_OUT_OF_RANGE_MESSAGE = "El género no está dentro de las opciones";
    public static final String GENDER_FIELD_NOT_NULL_MESSAGE = "El género debe ser seleccionado";
    public static final String INSTITUTIONAL_EMAIL_FIELD_INVALID_FORMAT_MESSAGE = "El correo institucional debe ";

    private UserAppConstants() {
        throw new IllegalStateException("Utility class");
    }
}
