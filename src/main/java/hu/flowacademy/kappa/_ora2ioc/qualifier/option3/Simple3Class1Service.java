package hu.flowacademy.kappa._ora2ioc.qualifier.option3;

import org.springframework.stereotype.Service;

@Service("sajatBeanNev")
public class Simple3Class1Service implements Simple3Interface {
    public String value() {
        return "Simple3Class1Service";
    }
}
