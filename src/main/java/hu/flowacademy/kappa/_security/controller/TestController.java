package hu.flowacademy.kappa._security.controller;

import hu.flowacademy.kappa._security.repository.User;
import hu.flowacademy.kappa._security.service.JwtComponent;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class TestController {

    private final JwtComponent jwt;
    private final PasswordEncoder passwordEncoder;

    TestController(JwtComponent jwt, PasswordEncoder passwordEncoder) {
        this.jwt = jwt;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String test(Principal principal) {
        return principal.getName();
    }

    /**
     * Mivel a @Valid generálhat annotációt, mikor az adatok a validáción elbuknak, így javasolt RestControllerAdvice alá helyezni
     * és humánosabb hiba üzenetet generálni. :)
     */
    @PostMapping
    @PreAuthorize("isAnonymous()")
    public String login(@RequestBody @Valid Login login) {
        // lekérdezzük a DB-ből az email alapján
        var data = new User();

        if (data.getPassword().equals(login.getPassword())) {
            return jwt.generate(data);
        }

        return "";
    }
}
