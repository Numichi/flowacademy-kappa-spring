package hu.flowacademy.kappa._other;

import hu.flowacademy.kappa.config.PropertiesConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SpringProfileDefaultTest {

    @Autowired
    PropertiesConfig config;

    @Test
    public void test() {
        assertEquals("dev-env", config.getParam1());
    }
}
