package hu.flowacademy.kappa._ora3test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@ExtendWith(MockitoExtension.class)
public class SpyTest {
    @Mock
    private List<String> mockList;

    @Spy
    private final List<String> spyList = new ArrayList<>();

    @Test
    public void testMockList() {
        mockList.add("test");

        assertEquals(0, mockList.size());
        assertNull(mockList.get(0));
    }

    @Test
    public void testSpyList() {
        spyList.add("test");

        assertEquals(1, spyList.size());
        assertEquals("test", spyList.get(0));
    }

    @Test
    public void testMockWithStub() {
        String expected = "Mock 100";

        // itt működik, hogy ha "ezt" kapod, akkor ad vissza "azt".
        given(mockList.get(100)).willReturn(expected);

        assertEquals(0, mockList.size());
        assertEquals(expected, mockList.get(100));
    }

    @Test
    public void testSpyWithStub() {
        String expected = "Spy 100";

        willReturn(expected).given(spyList).get(100);
        // doReturn(expected).when(spyList).get(100); // <-- "when" forma

        assertEquals(expected, spyList.get(100));
    }
}
