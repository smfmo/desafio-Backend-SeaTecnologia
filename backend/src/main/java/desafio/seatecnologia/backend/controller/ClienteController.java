package desafio.seatecnologia.backend.controller;

import desafio.seatecnologia.backend.controller.dto.ClienteDto;
import desafio.seatecnologia.backend.controller.mappers.ClienteMapper;
import desafio.seatecnologia.backend.model.Cliente;
import desafio.seatecnologia.backend.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@Tag(name = "Clientes")
public class ClienteController {

    private final ClienteService service;
    private final ClienteMapper mapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @Operation(summary = "Listar Clientes", description = "listar todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "clientes encontrados com sucesso"),
            @ApiResponse(responseCode = "401", description = "Usuário não cadastrado")
    })
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = service.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @Operation(summary = "Buscar dados", description = "retorna os dados do cliente pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "401", description = "Usuário não cadastrado")
    })
    public ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable("id") Long id) {
        Cliente cliente = service.buscarPorId(id);
        ClienteDto clienteDto = mapper.toDto(cliente);
        return ResponseEntity.ok(clienteDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Salvar", description = "salvar novo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "401", description = "Usuário não cadastrado")
    })
    public ResponseEntity<Void> salvarCliente(@RequestBody @Valid ClienteDto dto) {
        Cliente cliente = mapper.toEntity(dto);
        service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Atualizar", description = "Atualizar cliente existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "401", description = "Usuário não cadastrado")
    })
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id,
                                                    @RequestBody @Valid ClienteDto dto) {
        Cliente clienteAtualizado = service.atualizar(id, mapper.toEntity(dto));
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir", description = "Excluir cliente Existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Excluído com sucesso"),
            @ApiResponse(responseCode = "401", description = "Usuário não cadastrado")
    })
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
