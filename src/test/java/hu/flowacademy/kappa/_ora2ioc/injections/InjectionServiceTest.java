package hu.flowacademy.kappa._ora2ioc.injections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class InjectionServiceTest {

    @Autowired
    private InjectionService service;

    @Test
    void testAllAttributesNotNull() {
        assertNotNull(service.getComponent1());
        assertNotNull(service.getComponent2());
        assertNotNull(service.getComponent3());
    }
}