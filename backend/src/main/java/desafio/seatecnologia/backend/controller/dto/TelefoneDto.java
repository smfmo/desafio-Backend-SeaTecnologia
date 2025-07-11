package desafio.seatecnologia.backend.controller.dto;

import desafio.seatecnologia.backend.model.enums.TipoTelefone;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class TelefoneDto {
    @NotNull(message = "tipo de telefone é obrigatório")
    private TipoTelefone tipo;

    @NotBlank(message = "Número de telefone é obrigatório")
    @Pattern(regexp = "^(\\d{2}\\s?\\d{4,5}-?\\d{4})$", message = "Telefone inválido")
    private String numero;
}
