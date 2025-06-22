package co.edu.udea.nexum.profile.family_information.domain.utils.enums;

public enum MaritalState {
    MARRIED("Casado/a"),
    DIVORCED("Divorciado/a"),
    SINGLE("Soltero/a"),
    FREE_UNION("Unión Libre");


    public String name;

    MaritalState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
