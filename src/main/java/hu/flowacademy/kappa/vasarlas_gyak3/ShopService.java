package hu.flowacademy.kappa.vasarlas_gyak3;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository repository;

    ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public void addNewItem(Item item1) {
        repository.save(item1);
    }

    public Set<Item> getAll() {
        return repository.findAll()
                .stream()
                .map(item -> new Item(item.getId(), item.getTv(), item.getPrice() * 1.27))
                .collect(Collectors.toSet());
    }

    public Item get(int key) {
        var optional = repository.findById(key);
        var item = optional.orElseThrow();
        return new Item(item.getId(), item.getTv(), item.getPrice() * 1.27);
    }
}
