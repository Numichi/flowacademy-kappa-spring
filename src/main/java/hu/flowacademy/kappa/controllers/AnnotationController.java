package hu.flowacademy.kappa.controllers;

import hu.flowacademy.kappa.annobase.PeldaKetto;
import hu.flowacademy.kappa.annobase.TestClass1;
import hu.flowacademy.kappa.annobase.TestClass2;
import hu.flowacademy.kappa.aspect.ElsoPelda;
import hu.flowacademy.kappa.aspect.MethodSpeed;
import hu.flowacademy.kappa.controllers.model.ShopRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/annotation")
public class AnnotationController {

    private final ShopRequest shopRequest;

    public AnnotationController(ShopRequest shopRequest) {
        this.shopRequest = shopRequest;
    }

    @ElsoPelda
    @MethodSpeed
    @GetMapping("pelda1")
    public void proxyAnnotations() {
        shopRequest.setAddress("almafa");
    }

    @GetMapping("pelda2")
    public void manualAnnotations() {
        annoRun(new TestClass2());
        annoRun(new TestClass1());
        annoRun(new AnnotationController(shopRequest));
    }

    private void annoRun(Object object) {
        Class<?> clazz = object.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PeldaKetto.class)) {
                System.out.println("value="  + method.getAnnotation(PeldaKetto.class).value() + ", sargaDinnye=" + method.getAnnotation(PeldaKetto.class).sargaDinnye());
            }

            if (method.isAnnotationPresent(GetMapping.class)) {
                System.out.println("value="  + Arrays.toString(method.getAnnotation(GetMapping.class).value()));
            }
        }
    }
}
