package hu.flowacademy.kappa._ora2ioc.scope;

import hu.flowacademy.kappa._ora2ioc.scope.components.PrototypeScopeComponent;
import hu.flowacademy.kappa._ora2ioc.scope.components.RequestScopeComponent;
import hu.flowacademy.kappa._ora2ioc.scope.components.SingletonScopeComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class ScopeController {

    private final PrototypeScopeComponent property;
    private final RequestScopeComponent request;
    private final SingletonScopeComponent singleton;
    private final ScopeHelperComponent helper;

    public ScopeController(
            PrototypeScopeComponent property,
            RequestScopeComponent request,
            SingletonScopeComponent singleton,
            ScopeHelperComponent helper
    ) {
        this.property = property;
        this.request = request;
        this.singleton = singleton;
        this.helper = helper;
    }

    @GetMapping
    public void haveFun() {
        System.out.println("[1] Property Scope:  " + property.getValue());
        System.out.println("[1] Request Scope:   " + request.getValue());
        System.out.println("[1] Singleton Scope: " + singleton.getValue());
        System.out.println();

        helper.run();
        System.out.println("----------------------------------");
    }
}
