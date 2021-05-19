package hu.flowacademy.kappa.vasarlas_gyak3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ShopServiceTest {

    @MockBean
    ShopRepository repository;

    @Autowired
    ShopService service;

    @Test // integration
    @Disabled
    public void testAdd() {
        var item1 = new Item(1, "TV", 100000);
        var item2 = new Item(2, "TV", 100000);

        service.addNewItem(item1);
        service.addNewItem(item2);

        Set<Item> termekek = service.getAll();
        var item = termekek.stream().filter(x -> x.getId() == 1).collect(Collectors.toList()).get(0);

        assertEquals(item, item1);
    }

    @Test // unit
    public void testAddUnit() {
        var item1 = new Item(1, "TV", 100000);
        var item2 = new Item(2, "TV", 100000);

        given(repository.findAll()).willReturn(Set.of(item1, item2));

        Set<Item> termekek = service.getAll();
        var item = termekek.stream().filter(x -> x.getId() == 1).collect(Collectors.toList()).get(0);

        assertEquals(item, new Item(1, "TV", 127000));
    }

    @Test // unit
    public void testGetUnit() {
        given(repository.findById(1))
                .willReturn(Optional.of(new Item(1, "TV", 100000)));
        given(repository.findById(2))
                .willReturn(Optional.of(new Item(2, "Mikro", 100000)));

        assertEquals(service.get(1), new Item(1, "TV", 127000));
        assertEquals(service.get(2), new Item(2, "Mikro", 127000));
    }

}
