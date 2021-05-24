package hu.flowacademy.kappa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ShopService2Test {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void findById2() {
        shopRepository.save(new Shop(1, "ABC", List.of()));
        var shop = shopRepository.findById(1).orElseThrow();

        var preItem = new Item(1, 100.0, shop);
        itemRepository.save(preItem);
    }

    @Test
    void findById4() {
        shopRepository.save(new Shop(1, "ABC", List.of()));
        var shop = shopRepository.findById(1).orElseThrow();
        var preItem = new Item(1, 100.0, shop);
        itemRepository.save(preItem);

        System.out.println("-----------------------");
        var shop1 = shopRepository.findById(1).orElseThrow();
        System.out.println(shop1.getItems());
    }
}