package hu.flowacademy.kappa._ora2ioc.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ha megnézzük a QualifierService osztály, látjuk, hogy nincs megadva sp
 */
@SpringBootTest
class QualifierServiceTest {

    @Autowired
    private QualifierService service;

    @Test
    void testGetSimple1Service() {
        assertEquals("Simple1Service", service.getSimple1Service());
    }

    @Test
    void testGetSimple2Interface() {
        assertEquals("Simple2Service", service.getSimple2Interface());
    }

    @Test
    void testGetSimple3Class2Service() {
        assertEquals("Simple3Class2Service", service.getSimple3Class2Service());
    }

    @Test
    void getSimple3Class2Interface() {
        assertEquals("Simple3Class2Service", service.getSimple3Class2Interface());
    }

    @Test
    void getSimple3Class1Interface() {
        assertEquals("Simple3Class1Service", service.getSimple3Class1Interface());
    }

    @Test
    void getSimple4Class1Interface() {
        assertEquals("Simple4Class1Service", service.getSimple4Class1Interface());
    }

    @Test
    void getSimple4Class2Interface() {
        assertEquals("Simple4Class2Service", service.getSimple4Class2Interface());
    }
}