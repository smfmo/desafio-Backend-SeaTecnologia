package desafio.seatecnologia.backend.model;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@TypeDef(name = "list-array",
        typeClass = ListArrayType.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,
            unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Type(type = "list-array")
    @Column(name = "roles",
            columnDefinition = "varchar[]")
    private List<String> roles;
}
