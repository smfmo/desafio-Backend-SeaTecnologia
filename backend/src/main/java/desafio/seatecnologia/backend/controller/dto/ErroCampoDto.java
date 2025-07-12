package desafio.seatecnologia.backend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroCampoDto {
    String campo;
    String mensagem;
}
