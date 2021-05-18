package hu.flowacademy.kappa._ora2ioc.qualifier.option4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class Simple4Class2Service implements Simple4Interface {
    public String value() {
        return "Simple4Class2Service";
    }
}
