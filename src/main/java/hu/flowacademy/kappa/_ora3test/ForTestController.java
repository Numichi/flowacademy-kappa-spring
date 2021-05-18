package hu.flowacademy.kappa._ora3test;

import hu.flowacademy.kappa._ora1controller.FirstControllerHelper;
import hu.flowacademy.kappa._ora1controller.RequestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForTestController {

    private final FirstControllerHelper helper;

    // felhasználjuk az 1. órai anyagot
    ForTestController(FirstControllerHelper helper) {
        this.helper = helper;
    }

    @GetMapping("/api/v3")
    public RequestModel get() {
        return helper.model(null);
    }
}
