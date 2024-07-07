package restaurante.com.example.restauranteJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurante.com.example.restauranteJava.entities.produto.FotoProduto;

import java.util.Optional;
import java.util.UUID;

public interface FotoProdutoRepository extends JpaRepository<FotoProduto, UUID> {
    @Override
    Optional<FotoProduto> findById(UUID uuid);
    Optional<FotoProduto> findFotoProdutoByNome(String nome);
}
