package desafio.seatecnologia.backend.controller;

import desafio.seatecnologia.backend.controller.dto.EnderecoDto;
import desafio.seatecnologia.backend.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
@RequiredArgsConstructor
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public EnderecoDto getEndereco(@PathVariable("cep") String cep) {
        return cepService.buscarEnderecoPeloCep(cep);
    }

}
