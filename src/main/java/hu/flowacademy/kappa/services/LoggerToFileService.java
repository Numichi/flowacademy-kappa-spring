package hu.flowacademy.kappa.services;

import org.springframework.stereotype.Component;

@Component
class LoggerToConsoleService implements LoggerService  {
    public void log(String message) {
        System.out.println(message);
    }
}
