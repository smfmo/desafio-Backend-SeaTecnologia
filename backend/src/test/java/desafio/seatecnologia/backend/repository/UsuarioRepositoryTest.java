package desafio.seatecnologia.backend.repository;

import desafio.seatecnologia.backend.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@SpringBootTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Salvar usuários")
    @Transactional
    public void deveSalvarUsuarioComSucesso(){

        Usuario usuario = criarUsuarioAdminTest();
        Usuario usuarioSalvo = usuarioRepository.save(usuario); // action (ação)

        // Assert (verificação)
        assertNotNull(usuarioSalvo.getId());
        assertEquals(usuario.getUsername(), usuarioSalvo.getUsername());
        assertTrue(passwordEncoder.matches("123qwe!@#", usuarioSalvo.getPassword()));
        assertTrue(usuarioSalvo.getRoles().contains("ADMIN"));
    }

    @Test
    @DisplayName("Encontrar usuários pelo username")
    @Transactional
    public void findByUsernameTest(){

        Usuario usuario = criarUsuarioComumTest();
        usuarioRepository.save(usuario);
        Usuario usuarioEncontrado = usuarioRepository.findByUsername(usuario.getUsername());

        assertNotNull(usuarioEncontrado);
        assertEquals(usuario.getUsername(), usuarioEncontrado.getUsername());
        assertTrue(passwordEncoder.matches("123qwe123", usuarioEncontrado.getPassword()));
        assertTrue(usuarioEncontrado.getRoles().contains("USER"));
    }

    @DisplayName("método utilitário")
    private Usuario criarUsuarioAdminTest(){
        Usuario usuario = new Usuario();
        usuario.setUsername("admin");
        usuario.setPassword(passwordEncoder.encode("123qwe!@#"));
        usuario.setRoles(new ArrayList<>(Collections.singletonList("ADMIN")));
        return usuario;
    }
    @DisplayName("método utilitário")
    private Usuario criarUsuarioComumTest(){
        Usuario usuario = new Usuario();
        usuario.setUsername("user");
        usuario.setPassword(passwordEncoder.encode("123qwe123"));
        usuario.setRoles(new ArrayList<>(Collections.singletonList("USER")));
        return usuario;
    }

}