package hu.flowacademy.kappa._ora2ioc.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConfigBeanServiceTest {

    @Autowired
    private ConfigBeanService service;

    @Test
    void getBean1Class() {
        assertEquals("Bean1Class", service.getBean1Class());
    }

    @Test
    void getBean2Primary() {
        assertEquals("Bean2Class1", service.getBean2Primary());
    }

    @Test
    void getBean2NonPrimary() {
        assertEquals("Bean2Class2", service.getBean2NonPrimary());
    }
}