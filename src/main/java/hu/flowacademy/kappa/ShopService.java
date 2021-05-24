package hu.flowacademy.kappa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepository repository;

    ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public ShopRepository getRepository() {
        return repository;
    }

    public Shop findById(int id) {
        return repository.findById(1).orElse(null);
    }

    public List<Shop> findAll(int id) {
        return repository.findAll();
    }

    public void save(Shop item) {
        repository.save(item);
    }

    public void save(List<Shop> items) {
        repository.saveAll(items);
    }
}
