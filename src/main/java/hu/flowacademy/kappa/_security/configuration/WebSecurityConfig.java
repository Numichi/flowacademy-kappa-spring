package hu.flowacademy.kappa._security.configuration;

import hu.flowacademy.kappa._security.filter.AuthFilter;
import hu.flowacademy.kappa._security.service.JwtComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtComponent jwtComponent;

    WebSecurityConfig(JwtComponent jwtComponent) {
        this.jwtComponent = jwtComponent;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // API nem használ SESSION-t!
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Ezeket kikapcsoljuk. Utána olvashattok, hogy mi micsoda. :)
        http.cors().disable();
        http.csrf().disable();
        http.formLogin().disable();
        http.logout().disable();
        http.rememberMe().disable();

        // Hozzáadunk egy filter-t
        http.addFilter(new AuthFilter(jwtComponent));

        // Ha nem állítunk @PreAuthorize-t akkor permitAll lesz az alapértelmezett.
        http.authorizeRequests().mvcMatchers("/**").permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder();
    }
}
