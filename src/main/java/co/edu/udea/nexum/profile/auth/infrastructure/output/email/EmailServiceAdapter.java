package co.edu.udea.nexum.profile.auth.infrastructure.output.email;

import co.edu.udea.nexum.profile.auth.domain.spi.email.EmailServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailServiceAdapter implements EmailServicePort {

    private final EmailService emailService;

    @Override
    public void sendVerificationEmail(String to, String token) {
        emailService.sendVerificationEmail(to, token);
    }

    @Override
    public void sendPasswordResetEmail(String to, String token) {
        emailService.sendPasswordResetEmail(to, token);
    }
}