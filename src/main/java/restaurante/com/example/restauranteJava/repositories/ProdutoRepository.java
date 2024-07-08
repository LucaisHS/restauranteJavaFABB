package restaurante.com.example.restauranteJava.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restaurante.com.example.restauranteJava.entities.produto.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    @EntityGraph(attributePaths = {"foto"})
    Optional<Produto> findProdutoById(UUID id);

    @Query("SELECT p FROM produto p LEFT JOIN FETCH p.foto")
    List<Produto> findAll();
    Optional<Produto> findProdutoByNome(String nome);
}
