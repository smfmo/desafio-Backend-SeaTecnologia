package desafio.seatecnologia.backend.repository;

import desafio.seatecnologia.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
