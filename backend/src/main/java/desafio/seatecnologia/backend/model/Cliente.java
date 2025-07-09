package desafio.seatecnologia.backend.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String nome;

    @NotBlank
    private String cpf;

    @Embedded
    private Endereco endereco;

    @ElementCollection
    @CollectionTable(
            name = "telefones_cliente",
            joinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Telefone> telefones;

    @ElementCollection
    @CollectionTable(
            name = "emails_cliente",
            joinColumns = @JoinColumn(name = "cliente_id")
    )
    @Email
    private List<String> emails;
}
