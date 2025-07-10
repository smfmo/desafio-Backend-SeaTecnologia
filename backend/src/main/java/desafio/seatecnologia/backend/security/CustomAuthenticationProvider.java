package desafio.seatecnologia.backend.security;

import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String senhaDigitada = authentication.getCredentials().toString();

        Usuario usuarioEncontrado = usuarioService.findByUsername(username);

        if (usuarioEncontrado == null) {
            throw new UsernameNotFoundException("Usuário e/ou senha incorretos");
        }

        String senhaCriptografada = usuarioEncontrado.getPassword();
        boolean senhasBatem = passwordEncoder.matches(senhaDigitada, senhaCriptografada);

        if (senhasBatem){
            return new CustomAuthentication(usuarioEncontrado);
        }

       throw new UsernameNotFoundException("Usuário e/ou senha incorretos");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
