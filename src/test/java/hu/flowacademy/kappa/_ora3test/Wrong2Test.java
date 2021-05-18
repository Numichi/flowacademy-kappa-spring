package hu.flowacademy.kappa._ora3test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Wrong2Test {

    private Set<String> storage;

    @BeforeAll
    public void asd() {
        storage = new HashSet<>();
    }

    // Szándékosan van kikommentelve, mert ha lefagy, akkor az AfterEach-be nem jutna el egy összeomlás után.
    // ==================================================================================
    // @AfterEach
    // public void setUp() {
    //     storage.clear();
    // }

    @Test
    @Order(1)
    public void test1() {
        storage.add("xy");

        // Tegyük fel, hogy írtunk egy külső adatbázisba és összeomlik a rendszer. Az adatbázisban megmarad az adat. Újra indítás után a "test2"-vel kezd.
    }

    @Test
    @Order(2)
    public void test2() {
        assertNotEquals(0, storage.size());
    }
}
