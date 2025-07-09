package desafio.seatecnologia.backend.security;

import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario == null) {
            throw new BadCredentialsException("Usuario no encontrado");
        }
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new BadCredentialsException("senha incorreta");
        }

        List<SimpleGrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + usuario.getRoles())
        );

        return new UsernamePasswordAuthenticationToken(
                username,
                null,
                authorities
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
