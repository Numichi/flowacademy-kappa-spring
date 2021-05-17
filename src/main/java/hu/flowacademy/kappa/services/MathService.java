package hu.flowacademy.kappa.services;

import org.springframework.stereotype.Service;

@Service
public
class MathService {

    public Double osztas(double a, float b, double c) {
        if (b == 0) {
            throw new RuntimeException("Nem lehet 0!");
        }

        if (c == 0) {
            throw new RuntimeException("Nem lehet 0!");
        }

        return a / b / c;
    }

    public Double osztas(double a, float b) {
        if (b == 0) {
            throw new RuntimeException("Nem lehet 0!");
        }

        return osztas(a, b, 1);
    }
}
