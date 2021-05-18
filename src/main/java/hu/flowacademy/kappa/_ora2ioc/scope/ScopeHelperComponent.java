package hu.flowacademy.kappa._ora2ioc.scope;

import hu.flowacademy.kappa._ora2ioc.scope.components.PrototypeScopeComponent;
import hu.flowacademy.kappa._ora2ioc.scope.components.RequestScopeComponent;
import hu.flowacademy.kappa._ora2ioc.scope.components.SingletonScopeComponent;
import org.springframework.stereotype.Service;

@Service
public class ScopeHelperComponent {

    private final PrototypeScopeComponent property;
    private final RequestScopeComponent request;
    private final SingletonScopeComponent singleton;

    public ScopeHelperComponent(
            PrototypeScopeComponent property,
            RequestScopeComponent request,
            SingletonScopeComponent singleton
    ) {
        this.property = property;
        this.request = request;
        this.singleton = singleton;
    }

    public void run() {
        System.out.println("[2] Property Scope:  " + property.getValue());
        System.out.println("[2] Request Scope:   " + request.getValue());
        System.out.println("[2] Singleton Scope: " + singleton.getValue());
    }
}
