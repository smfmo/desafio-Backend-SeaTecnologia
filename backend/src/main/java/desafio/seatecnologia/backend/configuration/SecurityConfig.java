package desafio.seatecnologia.backend.configuration;

import desafio.seatecnologia.backend.security.CustomAuthenticationProvider;
import desafio.seatecnologia.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain
            (HttpSecurity http,
             CustomAuthenticationProvider authProvider) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/api/auth/**").permitAll()
                        .antMatchers("/clientes/**").hasAnyRole("ADMIN", "USER")
                        .antMatchers(HttpMethod.POST, "/clientes").hasRole("ADMIN")
                        .antMatchers(HttpMethod.PUT, "/clientes").hasRole("ADMIN")
                        .antMatchers(HttpMethod.DELETE, "/clientes").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authProvider)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider(
            UsuarioService usuarioService,
            PasswordEncoder passwordEncoder) {
        return new CustomAuthenticationProvider(usuarioService, passwordEncoder);
    }

}
