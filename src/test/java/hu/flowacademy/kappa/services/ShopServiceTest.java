package hu.flowacademy.kappa.services;

import hu.flowacademy.kappa.models.Shop;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopServiceTest {

    @Autowired
    ShopService service;

    @BeforeAll
    public static void staticSetUp() {
        System.out.println("staticSetUp");
    }

    @AfterAll
    public static void staticTearDown() {
        System.out.println("staticTearDown");
    }

    @BeforeEach
    public void setUp() {
        System.out.println(Instant.now().toEpochMilli());
        service.clear();
    }

    @AfterEach
    public void tearDown() {
        System.out.println(Instant.now().toEpochMilli());
    }

    @Nested
    @DisplayName("Adat lekérő teszt esetek")
    public class GetterMethods {

        @Test
        public void getZero() {
            System.out.println("getZero");
            assertEquals(0, service.size());
        }

        @Test
        public void getEgyElemu() {
            System.out.println("getEgyElemu");

            service.setShops(new Shop());
            assertEquals(1, service.size());
        }
    }

//    @Nested
//    @DisplayName("Adat beállító teszt esetek")
//    public class SetterMethods2 {
//
//        @Test
//        public void getZero() {
//
//        }
//    }
}