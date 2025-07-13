package desafio.seatecnologia.backend.controller;

import desafio.seatecnologia.backend.controller.dto.EnderecoDto;
import desafio.seatecnologia.backend.service.CepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
@RequiredArgsConstructor
@Tag(name = "Cep")
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    @Operation(summary = "Buscar endereço", description = "Buscar endereço pelo Cep")
    @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso")
    public EnderecoDto getEndereco(@PathVariable("cep") String cep) {
        return cepService.buscarEnderecoPeloCep(cep);
    }

}
