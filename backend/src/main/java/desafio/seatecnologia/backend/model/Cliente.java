package desafio.seatecnologia.backend.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes",
        schema = "public")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private List<String> email = new ArrayList<>();

    @Column(name = "telefones")
    @OneToMany(mappedBy = "clientes",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Telefone> telefone = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
