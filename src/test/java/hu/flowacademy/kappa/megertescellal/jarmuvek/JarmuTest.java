package hu.flowacademy.kappa.megertescellal.jarmuvek;

import hu.flowacademy.kappa.models.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
class JarmuTest {

    @MockBean
    AutoComponent jarmu;

//    @MockBean
//    AutoComponent component;

    @Test
    public void getEgyElemu() {
       when(jarmu.getWheel()).thenReturn(0);

       assertEquals(0, jarmu.getWheel());
    }

    @Test
    public void getEgyElemu1() {
        given(jarmu.getWheel()).willReturn(0);

        assertEquals(0, jarmu.getWheel());
    }

    @Test
    public void getEgyElemu6() {
        // given
        given(jarmu.passNumber(2)).willReturn(4);
        when(jarmu.passNumber(1)).thenReturn(2);

        // when
        var var1 = jarmu.passNumber(1);
        var var2 = jarmu.passNumber(2);

        // then
        assertEquals(2, var1);
        assertEquals(4, var2 );
    }

    @Test
    public void getEgyElemu2() {
        when(jarmu.passNumber(anyInt())).thenReturn(4);

        assertEquals(4, jarmu.passNumber(2));
        assertEquals(4, jarmu.passNumber(3));
        assertEquals(4, jarmu.passNumber(4));
    }

    @Test
    public void getEgyElemu5() {
        when(jarmu.passNumber(anyInt())).thenReturn(4);

        assertNotEquals(2, jarmu.passNumber(1));
    }

    @Test
    public void getEgyElemu3() {
        assertEquals(4, jarmu.passNumber(2));
        assertEquals(2, jarmu.passNumber(1));
    }
}