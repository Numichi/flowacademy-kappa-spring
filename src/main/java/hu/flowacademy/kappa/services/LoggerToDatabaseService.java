package hu.flowacademy.kappa.services;

import org.springframework.stereotype.Component;

@Component
public class LoggerToDatabaseService implements LoggerService {
    public void log(String message) {
        System.out.println(message);
    }
}