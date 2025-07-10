package desafio.seatecnologia.backend.service;

import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.model.enums.Roles;
import desafio.seatecnologia.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsuarioService  {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario){
        if (usuario.getPassword() == null){
            throw new IllegalArgumentException("Senha não pode ser nula");
        }
        if(usuario.getRoles() == null) {
            usuario.setRoles(Roles.USER);
        }

        String senhaUsuario = usuario.getPassword();
        usuario.setPassword(passwordEncoder.encode(senhaUsuario));
        return usuarioRepository.save(usuario);
    }

    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

}
