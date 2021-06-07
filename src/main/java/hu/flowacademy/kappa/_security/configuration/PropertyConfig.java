package hu.flowacademy.kappa._security.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class PropertyConfig {
    // Ide töltjük be a application-dev.yml-ből az app.secret-tet. FIGYELEM! Ha yml/priperties-ben közőjelet alkalmaztok, akkor itt Nagy betű lesz.
    // pl.: private String/Integer/Map<...>/... almaFa; // yml/priperties-ben: app.alma-fa

    private String secret;
}
