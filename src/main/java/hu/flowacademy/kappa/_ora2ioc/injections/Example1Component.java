package hu.flowacademy.kappa._ora2ioc.injections;

import org.springframework.stereotype.Component;

@Component
public class Example1Component {
    public String value() {
        return "Test data.";
    }
}
