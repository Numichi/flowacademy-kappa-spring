package hu.flowacademy.kappa._ora3test;

import hu.flowacademy.kappa._ora2ioc.qualifier.option2.Simple2Interface;
import hu.flowacademy.kappa._ora2ioc.qualifier.option3.Simple3Interface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class Mock3Test {

    // Ő az alkalmazás kontextusához (IoC-hoz) hozzáadja a Mock objektumot. Így a teszt futtatása során MINDIG érvényes lesz. Lásd a Mock4Test-tet.
    @MockBean
    Simple2Interface simple2Interface;

    @Autowired
    ApplicationContext context;

    @Test
    public void test1() {
        Mockito.when(simple2Interface.value()).thenReturn("almafa");

        Simple2Interface object = context.getBean(Simple2Interface.class); // Kézzel hívjuk az IoC-ból.
        String value = object.value();

        assertEquals("almafa", value);
    }
}
