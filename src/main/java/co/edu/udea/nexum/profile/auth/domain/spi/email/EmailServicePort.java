package co.edu.udea.nexum.profile.auth.domain.spi.email;

public interface EmailServicePort {
    void sendVerificationEmail(String to, String token);
    void sendPasswordResetEmail(String to, String token);
}