package desafio.seatecnologia.backend.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

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
    private List<String> emails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


}
