package hu.flowacademy.kappa;

import hu.flowacademy.kappa.services.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SpringBootTest
class KappaApplicationTests {
    @Autowired
    MathService math;

    @Test
    @DisplayName("2.0-t kapunk")
    void contextLoads() {
        Assertions.assertEquals(2.0,  math.osztas(2.0, 1.0f));
        Assertions.fail();
    }

    @Test
    @DisplayName("0-val osztunk")

    void contextLoad1() {
        try {
            Assertions.assertEquals(2.0,  math.osztas(2.0, 0.0f));
        } catch (RuntimeException e) {
            Assertions.assertEquals(1, 1);
        }
    }

    @Test
    @DisplayName("0-val osztunk v2")
    void testOsztasExceptionHandler() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertEquals(2.0,  math.osztas(2.0, 0.0f));
        });
    }
}
