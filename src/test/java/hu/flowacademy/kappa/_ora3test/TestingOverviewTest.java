package hu.flowacademy.kappa._ora3test;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingOverviewTest {

    @BeforeAll
    public static void setUpClass() {
        // Egyszer fut le, de minden elött
    }

    @BeforeEach
    public void setUp() {
        // Minden @Test előtt lefut
    }

    @AfterEach
    public void tearDown() {
        // Minden @Test után lefut
    }

    @AfterAll
    public static void tearDownClass() {
        // Egyszer fut le, de minden után
    }

    @Test
    @DisplayName("Matódus helyett, ez lesz a neve.")
    public void test1() {
        // ... test code
    }

    @Test
    @Disabled
    public void test2() {
        // A @Disabled miatt, ha nem direktben hívod, akkor NEM fog lefutni.
    }

    @Nested
    @DisplayName("Class-al tudsz akár csoportisítani teszteket is.")
    public class TestGroup {
        @Test
        public void test2() {
            // ... test code
        }

        @Test
        public void test3() {
            // ... test code
        }
    }
}
