package hu.flowacademy.kappa._other;

import hu.flowacademy.kappa.config.PropertiesConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class SpringProfileTestTest {

    @Autowired
    PropertiesConfig config;

    @Test
    public void test() {
        assertEquals("test-env", config.getParam1());
    }
}
