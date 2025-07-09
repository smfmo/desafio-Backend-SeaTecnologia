package desafio.seatecnologia.backend.model;

import desafio.seatecnologia.backend.model.enums.TipoTelefone;
import lombok.Data;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
@Embeddable
public class Telefone {

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    private String numero;
}
