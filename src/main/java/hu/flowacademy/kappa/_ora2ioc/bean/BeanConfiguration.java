package hu.flowacademy.kappa._ora2ioc.bean;

import hu.flowacademy.kappa._ora2ioc.bean.option1.Bean1Class;
import hu.flowacademy.kappa._ora2ioc.bean.option2.Bean2Class1;
import hu.flowacademy.kappa._ora2ioc.bean.option2.Bean2Class2;
import hu.flowacademy.kappa._ora2ioc.bean.option2.BeanInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * Két féle konfiguráció van:
 * - Implementálunk vagy "extends"-el öröklünk valamit, és konfigurálunk be valamit. Majd Spring Security-nál fogjuk használni, de bármikor kellhet. :)
 * - Vagy @Bean-el határozunk meg. Bean-nél fontos, hogy a metórus neve a Bean neve! Míg a @Component típusnál a Class nevéből képződik, ha nem adunk meg mást.
 *
 * Persze azért a kettőt lehet vegyíteni... Csak emlékez rá, hogy oda tetted a @Bean-t (>.<)
 */
@Configuration
public class BeanConfiguration {

    @Bean
    // @Scope // <-- ez a jószág itt is működne. :)
    public Bean1Class qwertz() {
        return new Bean1Class();
    }

    @Bean
    @Primary
    public BeanInterface szendvics() {
        return new Bean2Class1();
    }

    @Bean
    public BeanInterface hamburger() {
        return new Bean2Class2();
    }
}
