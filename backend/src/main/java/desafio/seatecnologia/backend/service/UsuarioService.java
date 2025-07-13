package desafio.seatecnologia.backend.service;

import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService  {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public void salvar(Usuario usuario){
        String senha = usuario.getPassword();
        usuario.setPassword(encoder.encode(senha));
        repository.save(usuario);
    }

    public Usuario findByUsername(String username){
        return repository.findByUsername(username);
    }
}
