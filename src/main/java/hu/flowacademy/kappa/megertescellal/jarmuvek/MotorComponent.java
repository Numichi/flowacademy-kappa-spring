package hu.flowacademy.kappa.megertescellal.jarmuvek;

import org.springframework.stereotype.Component;

@Component
public class MotorComponent implements Jarmu {

    @Override
    public int getWheel() {
        return 2;
    }
}
