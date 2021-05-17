package hu.flowacademy.kappa.controllers;

import hu.flowacademy.kappa.config.PropertiesConfig;
import hu.flowacademy.kappa.models.Shop;
import hu.flowacademy.kappa.controllers.model.ShopRequest;
import hu.flowacademy.kappa.services.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {
    private ShopService shops;

    public ShopController(ShopService shops) {
        this.shops = shops;
    }

    /**
     * Lekérdezzük a jelenlegi összes bolt-tot.
     */
    @GetMapping
    public Collection<Shop> getAllShop() {
        return shops.getShops();
    }

    /**
     * Lekérdezzük ID alapon. Ha nincs ilyen 404 Error code.
     */
    @GetMapping("{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Integer id) {
        var item = shops.getById(id);

        return (item != null) ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    /**
     * Feltöltünk egy Shop elemet.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postShop(@RequestBody ShopRequest model) {
        shops.init(model);
    }

    /**
     * Töröljük az ID elemét. Ha nem létezik, akkor töröltnek tekinthetjük.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postShop(@PathVariable Integer id) {
        shops.getShops().remove(id);
    }
}
