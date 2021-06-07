package hu.flowacademy.kappa._security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestControllerAdvice
public class AdviceController {

    /**
     * NoSuchElementException esetekre egy tartalom nélküli HTTP 404-et generálunk.
     * Ezt ugye olyan esetekre, ha DB-t használnánk és a következő dobna ilyet.
     *
     * @see Optional#orElseThrow()
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound() {}
}
