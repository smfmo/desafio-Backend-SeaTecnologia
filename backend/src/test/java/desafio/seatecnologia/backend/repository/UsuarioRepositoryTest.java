package desafio.seatecnologia.backend.repository;

import desafio.seatecnologia.backend.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions;
import java.util.Collections;


@ActiveProfiles("test")
@SpringBootTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "teste";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "123qwe!@#";

    @Test
    @DisplayName("Salvar usuários")
    public void salvarUsuarioTest(){
        // Arrange (preparação)
        Usuario usuario = new Usuario();
        usuario.setUsername(ADMIN_USERNAME);
        usuario.setPassword(passwordEncoder.encode(ADMIN_PASSWORD));
        usuario.setRoles(Collections.singletonList("ADMIN"));

        Usuario usuarioSalvo = usuarioRepository.save(usuario); // action (ação)

        // Assert (verificação)
        Assertions.assertNotNull(usuarioSalvo.getId());
        Assertions.assertEquals(ADMIN_USERNAME, usuarioSalvo.getUsername());
        Assertions.assertTrue(passwordEncoder.matches(ADMIN_PASSWORD, usuarioSalvo.getPassword()));
        Assertions.assertTrue(usuarioSalvo.getRoles().contains("ADMIN"));

        System.out.println("Usuario salvo com sucesso: \n" + usuarioSalvo);
    }

    @Test
    @DisplayName("Encontrar usuários pelo username")
    public void findByUsernameTest(){
        Usuario usuario = new Usuario();
        usuario.setUsername(USER_USERNAME);
        usuario.setPassword(passwordEncoder.encode(USER_PASSWORD));
        usuario.setRoles(Collections.singletonList("USER"));
        usuarioRepository.save(usuario);

        Usuario usuarioEncontrado = usuarioRepository.findByUsername(USER_USERNAME);


        Assertions.assertNotNull(usuarioEncontrado);
        Assertions.assertEquals(USER_USERNAME, usuarioEncontrado.getUsername());
        Assertions.assertTrue(passwordEncoder.matches(USER_PASSWORD, usuarioEncontrado.getPassword()));
        Assertions.assertTrue(usuarioEncontrado.getRoles().contains("USER"));

        System.out.println("Usuario encontrado com sucesso: \n" + usuarioEncontrado);
    }

}