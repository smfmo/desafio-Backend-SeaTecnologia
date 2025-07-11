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
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper mapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody @Valid ClienteDto dto) {
        Cliente cliente = mapper.toEntity(dto);
        Cliente clienteSalvo = clienteService.salvar(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
