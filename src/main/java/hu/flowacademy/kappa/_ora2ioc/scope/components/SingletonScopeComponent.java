package hu.flowacademy.kappa._ora2ioc.scope.components;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SingletonScopeComponent {
    @Getter
    private final String value;

    SingletonScopeComponent() {
        value = UUID.randomUUID().toString();
    }
}
