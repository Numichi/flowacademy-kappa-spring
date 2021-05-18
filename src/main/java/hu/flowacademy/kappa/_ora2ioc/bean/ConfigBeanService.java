package hu.flowacademy.kappa._ora2ioc.bean;

import hu.flowacademy.kappa._ora2ioc.bean.option1.Bean1Class;
import hu.flowacademy.kappa._ora2ioc.bean.option2.BeanInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConfigBeanService {

    private final Bean1Class bean1Class;
    private final BeanInterface bean2Primary;
    private final BeanInterface bean2NonPrimary;

    ConfigBeanService(
            Bean1Class bean1Class,
            BeanInterface bean2Primary,
            @Qualifier("hamburger") BeanInterface bean2NonPrimary
    ) {
        this.bean1Class = bean1Class;
        this.bean2Primary = bean2Primary;
        this.bean2NonPrimary = bean2NonPrimary;
    }

    public String getBean1Class() {
        return bean1Class.value();
    }

    public String getBean2Primary() {
        return bean2Primary.value();
    }

    public String getBean2NonPrimary() {
        return bean2NonPrimary.value();
    }
}
