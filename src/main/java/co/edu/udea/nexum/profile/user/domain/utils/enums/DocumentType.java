package co.edu.udea.nexum.profile.user.domain.utils.enums;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;

import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.*;

@Generated
public enum DocumentType {
    CC(CC_NAME, CC_ABBREV),
    TI(TI_NAME, TI_ABBREV),
    CE(CE_NAME, CE_ABBREV),
    TE(TE_NAME, TE_ABBREV),
    PP(PP_NAME, PP_ABBREV),
    PEP(PEP_NAME, PEP_ABBREV),
    NIT(NIT_NAME, NIT_ABBREV);

    private final String name;
    private final String abbreviation;

    DocumentType(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
