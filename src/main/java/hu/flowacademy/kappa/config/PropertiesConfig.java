package hu.flowacademy.kappa.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application")
public class PropertiesConfig {

    private String param1;
}


public class asd extends BasicAuthenticationFilter {

}