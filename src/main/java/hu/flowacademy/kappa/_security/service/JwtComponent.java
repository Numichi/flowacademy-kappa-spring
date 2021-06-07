package hu.flowacademy.kappa._security.service;

import hu.flowacademy.kappa._security.configuration.PropertyConfig;
import hu.flowacademy.kappa._security.configuration.Role;
import hu.flowacademy.kappa._security.repository.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtComponent {
    private final Key key;

    JwtComponent(PropertyConfig propertyConfig) {
        key = Keys.hmacShaKeyFor(propertyConfig.getSecret().getBytes());
    }

    public Authentication resolver(String jwt) {
        try {
            Claims claims = (Claims) Jwts.parserBuilder().setSigningKey(key).build().parse(jwt).getBody();

            // JWT-ben átadott ROLE-ok esetén a következő kellene:
            // Példa JWT Body JSON: { ..., "roles": ["ROLE_ASDASD", "USER_USER"], ... }
            //
            // Role[] roles = claims.get("roles", Role[].class);
            // var grantedAuthorities = Arrays.stream(roles).map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());

            return new UsernamePasswordAuthenticationToken(
                    claims.getSubject(),
                    null,
                    List.of(new SimpleGrantedAuthority(Role.ROLE_ASDASD.name())) // és ide nem a listát teszed beégetve, hanem a "grantedAuthorities" változót
            );
        } catch (Exception e) {
            return null;
        }
    }

    public String generate(User user) {
        var date = new Date();
        var dateExp = new Date(date.getTime() + 604_800_000);

        return Jwts.builder()
                .setIssuedAt(date) // létrehozá (ha szükséges)
                .setSubject(user.getUsername()) // kicsoda vagy milyen téma
                .setExpiration(dateExp) // JWT lejárata
                // minden más, ha kell
                .signWith(key) // ezzek a kulccsal
                .compact();
    }
}
