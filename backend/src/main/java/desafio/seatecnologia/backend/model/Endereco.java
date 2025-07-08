package desafio.seatecnologia.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "endereco",
        schema = "public")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "complemento")
    private String complemento;
}
