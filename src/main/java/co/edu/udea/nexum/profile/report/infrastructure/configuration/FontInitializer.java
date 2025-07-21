package co.edu.udea.nexum.profile.report.infrastructure.configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.InputStream;

@Component
@Slf4j
public class FontInitializer {

    @PostConstruct
    public void init() {
        registerTimesNewRomanFont();
    }

    private void registerTimesNewRomanFont() {
        try (InputStream fontStream = getClass().getClassLoader()
                .getResourceAsStream("templates/report/times.ttf")) {

            assert fontStream != null;
            Font tnr = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(tnr);
            log.info("✅ Fuente Times New Roman registrada.");

        } catch (Exception e) {
            throw new RuntimeException("No se pudo registrar la fuente Times New Roman", e);
        }
    }
}
