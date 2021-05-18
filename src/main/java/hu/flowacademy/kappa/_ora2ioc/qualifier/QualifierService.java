package hu.flowacademy.kappa._ora2ioc.qualifier;

import hu.flowacademy.kappa._ora2ioc.qualifier.option1.Simple1Service;
import hu.flowacademy.kappa._ora2ioc.qualifier.option2.Simple2Interface;
import hu.flowacademy.kappa._ora2ioc.qualifier.option3.Simple3Class2Service;
import hu.flowacademy.kappa._ora2ioc.qualifier.option3.Simple3Interface;
import hu.flowacademy.kappa._ora2ioc.qualifier.option4.Simple4Interface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QualifierService {

    private final Simple1Service simple1Service;
    private final Simple2Interface simple2Interface;
    private final Simple3Class2Service simple3Class2Service;
    private final Simple3Interface simple3Class2Interface;
    private final Simple3Interface simple3Class1Interface;
    private final Simple4Interface simple4Class2Interface;
    private final Simple4Interface simple4Class1Interface;

    public QualifierService(
            // Direct class
            Simple1Service simple1Service,

            // Interface (Azért működik, mert 1 interface-nek csak 1 implementációja van. Így adja magát.
            Simple2Interface simple2Interface,

            // Direct class (van interface-e, de most speciálisan ő kellet.. Fogjuk rá.)
            Simple3Class2Service simple3Class2Service,

            // Interface-t hívunk, de megadjuk melyik kell.
            @Qualifier("simple3Class2Service") Simple3Interface simple3Class2Interface, // @Qualifier paraméterében a Class neve "Simple3Class2Service", kicsi kezdőbetűvel, ha nincs speciális Bean név megadva
            @Qualifier("sajatBeanNev") Simple3Interface simple3Class1Interface, // Itt egyedi név került megadásra, így lehet úgy hivatkozni rá. Nézd meg a Simple3Class1Service-t

            // Hasonló a Simple3-hoz, de @Primary-val meg van jelölve.
            Simple4Interface simple4Class2Interface,
            @Qualifier("simple4Class1Service") Simple4Interface simple4Class1Interface // de ha mégis a másikra van szükség, akkor kell a @Qualifier..
    ) {
        this.simple1Service = simple1Service;
        this.simple2Interface = simple2Interface;
        this.simple3Class2Service = simple3Class2Service;
        this.simple3Class2Interface = simple3Class2Interface;
        this.simple3Class1Interface = simple3Class1Interface;
        this.simple4Class2Interface = simple4Class2Interface;
        this.simple4Class1Interface = simple4Class1Interface;
    }

    public String getSimple1Service() {
        return simple1Service.value();
    }

    public String getSimple2Interface() {
        return simple2Interface.value();
    }

    public String getSimple3Class2Service() {
        return simple3Class2Service.value();
    }

    public String getSimple3Class2Interface() {
        return simple3Class2Interface.value();
    }

    public String getSimple3Class1Interface() {
        return simple3Class1Interface.value();
    }

    public String getSimple4Class2Interface() {
        return simple4Class2Interface.value();
    }

    public String getSimple4Class1Interface() {
        return simple4Class1Interface.value();
    }
}
