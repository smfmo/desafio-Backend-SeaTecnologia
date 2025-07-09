package desafio.seatecnologia.backend.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class ClienteDto {
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "nome deve ter entre 3 e 100 caracteres")
    @Pattern(regexp = "^[\\p{L}0-9\\s]+$", message = "Nome só pode conter letras, números e espaços")
    private String nome;

    @NotBlank(message = "cpf é obrigatório")
    @CPF(message = "cpf inválido")
    private String cpf;

    @Valid
    @NotEmpty(message = "Pelo menos um telefone é obrigatório")
    private List<TelefoneDto> telefones;

    @Valid
    @NotEmpty(message = "Pelo menos um e-mail é obrigatório")
    private List< @Email String> emails;

    @Valid
    @NotNull(message = "Endereço é obrigatório")
    private EnderecoDto endereco;


}
