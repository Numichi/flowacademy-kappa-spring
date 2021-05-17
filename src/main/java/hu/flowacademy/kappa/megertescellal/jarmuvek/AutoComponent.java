package hu.flowacademy.kappa.megertescellal.jarmuvek;

import org.springframework.stereotype.Component;

@Component
public class AutoComponent implements Jarmu {

    @Override
    public int getWheel() {
        // code

        return 4;
    }

    public int passNumber(int x) {
        return x;
    }
}
