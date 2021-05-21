package hu.flowacademy.kappa.vasarlas_gyak3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/vasarlas")
public class VasarlasController {

    private ShopService service;

    VasarlasController(ShopService service) {
        this.service = service;
    }

    @GetMapping("termekek")
    public Set<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("kivalaszt/{id}")
    public Item getAll(@PathVariable int id) {
        return service.get(id);
    }
}
