package restaurante.com.example.restauranteJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurante.com.example.restauranteJava.entities.cidade.Cidade;
import restaurante.com.example.restauranteJava.entities.estado.Estado;

import java.util.Optional;
import java.util.UUID;

public interface CidadeRepository extends JpaRepository<Cidade, UUID> {
    Optional<Cidade> findCidadeById(UUID id);
    Optional<Cidade> findCidadeByEstadoAndNome(Estado estado, String nome);
}
