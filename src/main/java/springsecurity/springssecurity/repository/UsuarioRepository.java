package springsecurity.springssecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecurity.springssecurity.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    Usuario findByUsername(String username);
}
