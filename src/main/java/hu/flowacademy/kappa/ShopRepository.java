package hu.flowacademy.kappa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    // SELECT * FROM shop WHERE title LIKE '%?%'
    Set<Shop> findByTitleContaining(String title);

    // SELECT * FROM shop WHERE title = '?'
    Set<Shop> findAllByTitle(String title);

    Optional<Shop> findByTitle(String title);
}
