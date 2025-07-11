package desafio.seatecnologia.backend.service;

import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService  {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void salvar(Usuario usuario){
        String senha = usuario.getPassword();
        usuario.setPassword(passwordEncoder.encode(senha));
        usuarioRepository.save(usuario);
    }

    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
