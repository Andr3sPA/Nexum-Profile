package co.edu.udea.nexum.profile.user.domain.utils.constants;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.Role;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;

@Generated
public class UserConstants {

    public static final String TI_NAME = "Tarjeta de Identidad";
    public static final String TI_ABBREV = "TI";
    public static final String CC_NAME = "Cédula";
    public static final String CC_ABBREV = "CC";
    public static final String TE_NAME = "Tarjeta de Extranjería";
    public static final String TE_ABBREV = "TE";
    public static final String CE_NAME = "Cédula de Extranjería";
    public static final String CE_ABBREV = "CE";
    public static final String PP_NAME = "Pasaporte";
    public static final String PP_ABBREV = "PP";
    public static final String PEP_NAME = "Permiso Especial de Permanencia";
    public static final String PEP_ABBREV = "PEP";
    public static final String NIT_NAME = "Número de Identificación Tributaria";
    public static final String NIT_ABBREV = "NIT";

    public static final String MALE_NAME = "Hombre";
    public static final String MALE_ABBREVIATION = "H";
    public static final String FEMALE_NAME = "Mujer";
    public static final String FEMALE_ABBREVIATION = "M";
    public static final String NON_BINARY_NAME = "No binario";
    public static final String NON_BINARY_ABBREVIATION = "NB";
    public static final String OTHER_NAME = "Otro";
    public static final String OTHER_ABBREVIATION = "O";

    // Regex
    public static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String PHONE_NUMBER_REGEX = "^(\\+\\d{2})?\\d{10}$";
    public static final String IDENTITY_DOCUMENT_REGEX = "^\\w{6,16}";
    public static final String EMAIL_ATTRIBUTE = "email";
    public static final String IDENTITY_DOCUMENT_ATTRIBUTE = "identityDocument";
    public static final String INSTITUTIONAL_EMAIL_REGEX = "^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@udea\\.edu\\.co$";

    public static final ContactInformation DEFAULT_NULL_CONTACT_INFORMATION = ContactInformation.builder().build();
    public static final Auth DEFAULT_NULL_AUTH = Auth.builder().role(Role.builder().name(RoleName.GRADUATE).build()).build();

    private UserConstants() {
        throw new IllegalStateException("Utility class");
    }
}
