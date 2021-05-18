package hu.flowacademy.kappa._ora1controller.jarmuvek;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/motor")
public class MotorController {

    private final Jarmu motorComponent;

    MotorController(@Qualifier("motorComponent") Jarmu motorComponent) {
        this.motorComponent = motorComponent;
    }
}
