package hu.flowacademy.kappa.jarmuvek;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/motor")
public class MotorController {

    private final Jarmu motorComponent;

    MotorController(@Qualifier("motorComponent") Jarmu motorComponent) {
        this.motorComponent = motorComponent;
    }

    @GetMapping
    public int getMotorValue() {
        return motorComponent.getWheel();
    }
}
