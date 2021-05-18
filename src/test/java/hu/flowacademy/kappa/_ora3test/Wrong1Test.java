package hu.flowacademy.kappa._ora3test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Wrong1Test {

    private final Set<String> storage = new HashSet<>();

    @BeforeEach
    public void setUp() {
        storage.clear();
    }

    @Test
    @Order(1)
    public void test1() {
        storage.add("xy");

        // Tegyük fel, hogy írtunk egy külső adatbázisba és lefagy a rendszer. Az adatbázisban megmarad az adat. Újra indítás után a "test2"-vel kezd.
    }

    @Test
    @Order(2)
    public void test2() {
        assertEquals(0, storage.size());
    }
}
