package hu.flowacademy.kappa;

import hu.flowacademy.kappa.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KappaApplicationTests {

    @Autowired
    PropertiesConfig config;
}
