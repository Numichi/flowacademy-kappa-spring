package hu.flowacademy.kappa.services;

import org.springframework.stereotype.Component;

@Component
public class LoggerToConsoleService implements LoggerService  {
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public boolean log() {
        // logglunk

        return true;
    }
}
