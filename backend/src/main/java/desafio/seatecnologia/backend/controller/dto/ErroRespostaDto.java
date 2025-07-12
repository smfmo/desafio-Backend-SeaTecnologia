package desafio.seatecnologia.backend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class ErroRespostaDto {
    int status;
    String mensagem;
    List<ErroCampoDto> erros;

    public static ErroRespostaDto respostaPadrao(String mensagem) {
        return new ErroRespostaDto(HttpStatus.BAD_REQUEST.value(), mensagem, Collections.emptyList());
    }

    public static ErroRespostaDto conflito(String mensagem) {
        return new ErroRespostaDto(HttpStatus.CONFLICT.value(), mensagem, Collections.emptyList());
    }


}