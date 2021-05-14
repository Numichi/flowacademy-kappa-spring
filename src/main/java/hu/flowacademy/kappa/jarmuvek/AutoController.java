package hu.flowacademy.kappa.jarmuvek;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auto")
public class AutoController {

    private final Jarmu autoComponent;

    AutoController(@Qualifier("autoComponent") Jarmu autoComponent) {
        this.autoComponent = autoComponent;
    }

    @GetMapping
    public int getAutoValue() {
        return autoComponent.getWheel();
    }
}
