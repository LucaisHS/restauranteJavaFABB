package restaurante.com.example.restauranteJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurante.com.example.restauranteJava.entities.permissao.Permissao;

import java.util.Optional;
import java.util.UUID;

public interface PermissaoRepository extends JpaRepository<Permissao, UUID> {
    @Override
    Optional<Permissao> findById(UUID id);
}
