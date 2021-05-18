package hu.flowacademy.kappa._ora1controller.jarmuvek;

import org.springframework.stereotype.Component;

@Component
public class MotorComponent implements Jarmu {

    @Override
    public int getWheel() {
        return 2;
    }
}
