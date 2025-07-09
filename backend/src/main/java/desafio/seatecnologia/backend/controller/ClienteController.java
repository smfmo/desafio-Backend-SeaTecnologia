package desafio.seatecnologia.backend.controller;

import desafio.seatecnologia.backend.controller.dto.ClienteDto;
import desafio.seatecnologia.backend.controller.mappers.ClienteMapper;
import desafio.seatecnologia.backend.model.Cliente;
import desafio.seatecnologia.backend.service.ClienteService;
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
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper mapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping(params = "id")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ClienteDto> buscarClientePorId(Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteDto clienteDto = mapper.toDto(cliente);

        return ResponseEntity.ok(clienteDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody ClienteDto dto) {
        Cliente cliente = mapper.toEntity(dto);
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
