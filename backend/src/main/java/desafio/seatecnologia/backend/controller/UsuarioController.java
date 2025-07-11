package desafio.seatecnologia.backend.controller;

import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
    }
}
