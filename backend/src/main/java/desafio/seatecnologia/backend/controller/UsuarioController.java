package desafio.seatecnologia.backend.controller;

import desafio.seatecnologia.backend.controller.dto.UsuarioDto;
import desafio.seatecnologia.backend.controller.mappers.UsuarioMapper;
import desafio.seatecnologia.backend.model.Usuario;
import desafio.seatecnologia.backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@Tag(name = "usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Salvar", description = "Salvar usuário")
    @ApiResponse(responseCode = "201", description = "usuário salvo com sucesso")
    public void salvarUsuario(@RequestBody @Valid UsuarioDto dto) {
        Usuario usuario = mapper.toEntity(dto);
        service.salvar(usuario);
    }
}
