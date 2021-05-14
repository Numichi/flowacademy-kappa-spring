package hu.flowacademy.kappa.jarmuvek;

import org.springframework.stereotype.Component;

@Component
public class MotorComponent implements Jarmu {

    @Override
    public int getWheel() {
        return 2;
    }
}
