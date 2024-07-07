package restaurante.com.example.restauranteJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurante.com.example.restauranteJava.entities.cozinha.Cozinha;

import java.util.Optional;
import java.util.UUID;

public interface CozinhaRepository extends JpaRepository<Cozinha, UUID> {
    Optional<Cozinha> findCozinhaById(UUID id);
}
