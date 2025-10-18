package co.edu.udea.nexum.profile.auth.infrastructure.output.email;

import brevo.ApiClient;
import brevo.ApiException;
import brevo.Configuration;
import brevo.auth.ApiKeyAuth;
import brevoApi.TransactionalEmailsApi;
import brevoModel.SendSmtpEmail;
import brevoModel.SendSmtpEmailSender;
import brevoModel.SendSmtpEmailTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    @Value("${brevo.api-key}")
    private String apiKey;

    @Value("${NEXUM_FRONT_ORIGIN:http://localhost:3000}")
    private String frontUrl;

    private TransactionalEmailsApi getTransactionalEmailsApi() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKeyAuth.setApiKey(apiKey);
        return new TransactionalEmailsApi(defaultClient);
    }

    public void sendVerificationEmail(String to, String token) {
        try {
            TransactionalEmailsApi apiInstance = getTransactionalEmailsApi();

            SendSmtpEmailSender sender = new SendSmtpEmailSender();
            sender.setEmail("noreplyudea3453hl@gmail.com");
            sender.setName("Nexum Profile");

            SendSmtpEmailTo recipient = new SendSmtpEmailTo();
            recipient.setEmail(to);

            SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();
            sendSmtpEmail.setSender(sender);
            sendSmtpEmail.setTo(Collections.singletonList(recipient));
            sendSmtpEmail.setSubject("Verifica tu cuenta - Nexum Profile");

            String htmlContent = "<p>Haz clic en el siguiente enlace para verificar tu cuenta:</p>" +
                    "<p><a href=\"%s/auth/verify?token=%s\">Verificar cuenta</a></p>" +
                    "<p>Si no puedes hacer clic, copia y pega este enlace en tu navegador: http://localhost:8100/nexum/api/v1/auth/verify?token=%s</p>";
            htmlContent = String.format(htmlContent, frontUrl);

            sendSmtpEmail.setHtmlContent(htmlContent);

            apiInstance.sendTransacEmail(sendSmtpEmail);
            log.info("Verification email sent to {}", to);
        } catch (ApiException e) {
            log.error("Failed to send verification email to {}: {}", to, e.getMessage());
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendPasswordResetEmail(String to, String token) {
        try {
            TransactionalEmailsApi apiInstance = getTransactionalEmailsApi();

            SendSmtpEmailSender sender = new SendSmtpEmailSender();
            sender.setEmail("noreplyudea3453hl@gmail.com");
            sender.setName("Nexum Profile");

            SendSmtpEmailTo recipient = new SendSmtpEmailTo();
            recipient.setEmail(to);

            SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();
            sendSmtpEmail.setSender(sender);
            sendSmtpEmail.setTo(Collections.singletonList(recipient));
            sendSmtpEmail.setSubject("Restablecer contraseña - Nexum Profile");

            String htmlContent = "<p>Haz clic en el siguiente enlace para restablecer tu contraseña:</p>" +
                    "<p><a href=\"<frontUrl>/auth/reset-password?token=<token>\">Restablecer contraseña</a></p>" +
                    "<p>Si no puedes hacer clic, copia y pega este enlace en tu navegador: <frontUrl>/auth/reset-password?token=<token></p>";

            htmlContent = htmlContent.replace("<frontUrl>", frontUrl);
            htmlContent = htmlContent.replace("<token>", token);

            sendSmtpEmail.setHtmlContent(htmlContent);

            apiInstance.sendTransacEmail(sendSmtpEmail);
            log.info("Password reset email sent to {}", to);
        } catch (ApiException e) {
            log.error("Failed to send password reset email to {}: {}", to, e.getMessage());
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
