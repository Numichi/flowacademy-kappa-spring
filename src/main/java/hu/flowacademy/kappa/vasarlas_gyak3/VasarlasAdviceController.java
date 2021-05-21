package hu.flowacademy.kappa.vasarlas_gyak3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class VasarlasAdviceController {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.OK)
    public Item error(NoSuchElementException e) {
        return new Item(0, "", 0);
    }
}
