package hu.flowacademy.kappa._security.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hu.flowacademy.kappa._security.validation.Password;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Hogy a Validation működjün kell a @Valid annotáció a Controllerben.
 * 
 * @see TestController#login(Login) 
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {

    @Email // Email-nek kell lennie, de elfogadja a NULL-t is.
    @NotNull // Nem fogadatunk el NULL-t!!
    private String email;
    
    @Password(minUpper = 2) // minDigit és a minLower default miatt 1 lesz. (nem kell a default-tot kiírni)
    @NotNull
    private String password;
}
