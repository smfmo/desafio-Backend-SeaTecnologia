package desafio.seatecnologia.backend.model;

import desafio.seatecnologia.backend.model.enums.Roles;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,
            unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles roles;
}
