package hu.flowacademy.kappa._ora2ioc.qualifier.option2;

import org.springframework.stereotype.Service;

@Service
public class Simple2Service implements Simple2Interface {
    public String value() {
        return "Simple2Service";
    }
}
