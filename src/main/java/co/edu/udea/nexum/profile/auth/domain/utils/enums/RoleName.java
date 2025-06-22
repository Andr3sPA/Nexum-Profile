package co.edu.udea.nexum.profile.auth.domain.utils.enums;

public enum RoleName {
    /**
     * An administrative can add, read, modify and filter graduates, but cannot remove it
     */
    ADMINISTRATIVE,
    /**
     * A graduate can modify their information and add updates
     */
    GRADUATE,
    /**
     * A Dean can list and filter to search graduates
     */
    DEAN,
}
