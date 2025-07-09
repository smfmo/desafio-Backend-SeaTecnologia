package desafio.seatecnologia.backend.repository;

import desafio.seatecnologia.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
