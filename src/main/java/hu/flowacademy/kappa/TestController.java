package hu.flowacademy.kappa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ShopService service;

    TestController(ShopService service) {
        this.service = service;
    }

    @GetMapping("tan1")
    public Shop getAll() {
        return service.findById(1);
    }
}
