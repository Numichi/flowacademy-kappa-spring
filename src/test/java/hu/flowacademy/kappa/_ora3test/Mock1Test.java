package hu.flowacademy.kappa._ora3test;

import hu.flowacademy.kappa._ora2ioc.qualifier.option3.Simple3Interface;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

// itt nincs annotáció
public class Mock1Test {

    @Test
    public void testWhen() {
        Simple3Interface simple3Interface = Mockito.mock(Simple3Interface.class);

        Mockito.when(simple3Interface.value()).thenReturn("almafa");

        String value = simple3Interface.value();

        assertEquals("almafa", value);

        // Ellenőrzi, hogy tényleg meghívásra került-e a value().
        verify(simple3Interface).value();
    }

    @Test
    public void testGiven() {
        Simple3Interface simple3Interface = Mockito.mock(Simple3Interface.class);

        BDDMockito.given(simple3Interface.value()).willReturn("almafa");

        String value = simple3Interface.value();

        assertEquals("almafa", value);

        // Ellenőrzi, hogy tényleg meghívásra került-e a value().
        verify(simple3Interface).value();
    }

//    @Test
//    public void test2() {
//        Simple3Interface simple3Interface = Mockito.mock(Simple3Interface.class);
//        Mockito.when(simple3Interface.value()).thenReturn("almafa");
//
//        String value = simple3Interface.value();
//
//        assertEquals("almafa", value);
//
//        verify(simple3Interface, times(2)).value();
//    }
}
