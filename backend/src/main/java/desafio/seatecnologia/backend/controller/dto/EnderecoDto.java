package desafio.seatecnologia.backend.controller.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class EnderecoDto {
    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP deve ter 8 dígitos (sem máscara)")
    private String cep;

    @NotBlank(message = "Logradouro é obrigatório")
    private String logradouro;

    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "cidade é obrigatório")
    private String cidade;

    @NotBlank(message = "UF é obrigatório")
    @Size(min = 2, max = 2, message = "UF deve ter 2 caracteres")
    private String uf;

    private String complemento;
}
