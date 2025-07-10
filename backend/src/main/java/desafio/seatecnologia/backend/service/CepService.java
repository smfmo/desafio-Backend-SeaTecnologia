package desafio.seatecnologia.backend.service;

import desafio.seatecnologia.backend.controller.dto.EnderecoDto;
import desafio.seatecnologia.backend.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private static final String VIACEP_URL = "https://viacep.com.br/ws/%s/json/";
    public EnderecoDto buscarEnderecoPeloCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(VIACEP_URL, cep);
        return restTemplate.getForObject(url, EnderecoDto.class);
    }
}
