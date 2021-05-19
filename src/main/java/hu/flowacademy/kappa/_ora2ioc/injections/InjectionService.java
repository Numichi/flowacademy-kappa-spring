package hu.flowacademy.kappa._ora2ioc.injections;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Focus: A 3 féle "Dependency Injection"
 */
@Service
public class InjectionService {

    @Getter
    private final Example1Component component1;

    @Autowired
    @Getter
    private Example1Component component2;

    @Getter
    private Example1Component component3;

    // Célszerű a Construct-ot használni.
    InjectionService(Example1Component component) {
        this.component1 = component;
    }

    @Autowired
    public void setComponent3(Example1Component component) {
        this.component3 = component;
    }
}
