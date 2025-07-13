package desafio.seatecnologia.backend.controller.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UsuarioDto {
    @NotBlank(message = "Campo obrigatório")
    private String username;
    @NotBlank(message = "Campo obrigatório")
    private String password;
    @NotEmpty(message = "Campo não pode ser vazio")
    private List<String> roles;
}
