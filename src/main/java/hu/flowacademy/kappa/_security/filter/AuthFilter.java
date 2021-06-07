package hu.flowacademy.kappa._security.filter;

import hu.flowacademy.kappa._security.service.JwtComponent;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtComponent jwtComponent;

    public AuthFilter(JwtComponent jwtComponent) {
        this.jwtComponent = jwtComponent;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // Át castoljuk a kérést, mert a ServletRequest nem szolgáltat getHeader metórust. :/
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Kiszedjük a header-t ("Authorization" az általában elfogadott és az Application Firewall-ok általában átengedik. Ha ez egyedi, nem biztos.)
        // Ha van valami felesleges prefix a JWT elött, akkor vágjuk ki.
        String header =  httpRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null) {
            // Megpróbáljuk kikeresni az user-t JWT alapján és csinálunk neki egy Token-t a request végéig. (Ofc. Minden request-nél ez megfog történni...)
            Authentication auth = jwtComponent.resolver(header);

            if (auth != null) {
                // Ha nem NULL, akkor hadszóljon. :)
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        // Ha ő nincs, nem tud végig menni a filter láncon a kérés, és "elveszik" a kérés!
        chain.doFilter(request, response);
    }
}
