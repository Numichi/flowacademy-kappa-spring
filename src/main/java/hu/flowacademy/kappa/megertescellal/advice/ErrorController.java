package hu.flowacademy.kappa.megertescellal.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/error")
public class ErrorController {

    @GetMapping
    public void error() {
        throw new NoSuchElementException("Saját hiba!");
    }
}
