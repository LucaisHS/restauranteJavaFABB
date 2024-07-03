package restaurante.com.example.restauranteJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurante.com.example.restauranteJava.entities.usuario.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findUsuarioById(UUID id);
}
