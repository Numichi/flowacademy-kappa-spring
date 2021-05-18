package hu.flowacademy.kappa._ora3test;

import hu.flowacademy.kappa._ora2ioc.qualifier.option3.Simple3Interface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Mock2Test {

    // @Mock miatt kell a "@ExtendWith(MockitoExtension.class)"
    @Mock
    Simple3Interface simple3Interface;

    @Test
    public void test1() {
        Mockito.when(simple3Interface.value()).thenReturn("almafa");

        String value = simple3Interface.value();

        assertEquals("almafa", value);
    }
}
