package desafio.seatecnologia.backend.service;

import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void salvar(Usuario usuario){
        String senhaUsuario = usuario.getPassword();
        usuario.setPassword(passwordEncoder.encode(senhaUsuario));
        usuarioRepository.save(usuario);
    }

    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
