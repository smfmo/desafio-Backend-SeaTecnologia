package desafio.seatecnologia.backend.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import desafio.seatecnologia.backend.model.enums.TipoTelefone;
import desafio.seatecnologia.backend.util.json.deserializer.TelefoneDeserializer;
import desafio.seatecnologia.backend.util.json.serializer.TelefoneSerializer;
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
    @JsonSerialize(using = TelefoneSerializer.class)
    @JsonDeserialize(using = TelefoneDeserializer.class)
    private String numero;
}
