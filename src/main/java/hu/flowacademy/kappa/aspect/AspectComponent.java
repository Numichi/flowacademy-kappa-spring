package hu.flowacademy.kappa.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;

@Aspect
@Component
public class AspectComponent {

    @Before("@annotation(ElsoPelda)")
    public void beforeFunction(JoinPoint joinPoint) {
        System.out.println("Ez " + joinPoint.getArgs().length + " paraméterrel rendelkezik és értékei: ");

        Arrays.stream(joinPoint.getArgs())
                .map((item) -> "- " + item.toString())
                .forEach(System.out::println);
    }

    @Around("@annotation(MethodSpeed)")
    public Object afterFunction(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(Instant.now().toEpochMilli());
        var result = pjp.proceed();
        System.out.println(Instant.now().toEpochMilli());
        return result;
    }

    @Before("execution(* hu.flowacademy..*(..))")
    public void mindenreIs(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }
}
