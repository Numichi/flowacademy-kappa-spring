package hu.flowacademy.kappa._ora2ioc.scope.components;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeScopeComponent {
    @Getter
    private final String value;

    PrototypeScopeComponent() {
        value = UUID.randomUUID().toString();
    }
}
