package hu.flowacademy.kappa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class KappaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KappaApplication.class, args);
    }

}
