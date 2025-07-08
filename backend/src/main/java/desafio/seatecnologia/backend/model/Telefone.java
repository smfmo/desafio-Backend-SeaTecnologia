package desafio.seatecnologia.backend.model;

import desafio.seatecnologia.backend.model.enums.TipoTelefone;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "telefones",
        schema = "public")
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
