package hu.flowacademy.kappa.jarmuvek;

import org.springframework.stereotype.Component;

@Component
public class AutoComponent implements Jarmu {

    @Override
    public int getWheel() {
        return 4;
    }
}
