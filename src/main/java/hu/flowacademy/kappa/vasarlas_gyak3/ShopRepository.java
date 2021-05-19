package hu.flowacademy.kappa.vasarlas_gyak3;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class ShopRepository {
    Set<Item> set = new HashSet<>();

    public void save(Item item) {
        set.add(item);
    }

    public Set<Item> findAll() {
        return set;
    }

    public Optional<Item> findById(int id) {
        for (Item i : set) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }
}
