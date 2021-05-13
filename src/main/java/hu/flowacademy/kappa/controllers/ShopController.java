package hu.flowacademy.kappa.controllers;

import hu.flowacademy.kappa.models.Shop;
import hu.flowacademy.kappa.controllers.model.ShopRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {
    // TODO: @Service-be áthelyezni és szálbiztossá tenni!
    /** Nem Thread safe! Csak példa miatt használtuk a Map-ot! */
    private int id = 0;
    private final Map<Integer, Shop> shops = new HashMap<>();

    /**
     * Lekérdezzük a jelenlegi összes bolt-tot.
     */
    @GetMapping
    public Collection<Shop> getAllShop() {
        return shops.values();
    }

    /**
     * Lekérdezzük ID alapon. Ha nincs ilyen 404 Error code.
     */
    @GetMapping("{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Integer id) {
        var item = shops.get(id);

        return (item != null) ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    /**
     * Feltöltünk egy Shop elemet.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postShop(@RequestBody ShopRequest model) {
        var newId = id++;

        var shop = new Shop();
        shop.setId(newId);
        shop.setName(model.getName());
        shop.setCategory(model.getCategory());
        shop.setSettlement(model.getSettlement());
        shop.setZip(model.getZip());

        shops.put(newId, shop);
    }

    /**
     * Töröljük az ID elemét. Ha nem létezik, akkor töröltnek tekinthetjük.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@PathVariable Integer id) {
        shops.remove(id);
    }
}
