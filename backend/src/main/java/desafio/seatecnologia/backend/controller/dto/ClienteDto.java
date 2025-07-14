package desafio.seatecnologia.backend.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import desafio.seatecnologia.backend.util.json.deserializer.CpfDeserializer;
import desafio.seatecnologia.backend.util.json.serializer.CpfSerializer;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class ClienteDto {

    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "nome deve ter entre 3 a 100 caracteres")
    @Pattern(regexp = "^[\\p{L}0-9\\s]+$", message = "Nome só pode conter letras, números e espaços")
    private String nome;

    @NotBlank(message = "cpf é obrigatório")
    @CPF(message = "cpf inválido")
    @JsonSerialize(using = CpfSerializer.class)
    @JsonDeserialize(using = CpfDeserializer.class)
    private String cpf;

    @Valid
    @NotEmpty(message = "Pelo menos um telefone é obrigatório")
    private List<TelefoneDto> telefones;

    @Valid
    @NotEmpty(message = "Pelo menos um e-mail é obrigatório")
    private List<@Email String> emails;

    @Valid
    @NotNull(message = "Endereço é obrigatório")
    private EnderecoDto endereco;
}
