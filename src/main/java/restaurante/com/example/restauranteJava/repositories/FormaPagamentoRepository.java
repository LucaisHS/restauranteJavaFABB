package restaurante.com.example.restauranteJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurante.com.example.restauranteJava.entities.formaPagamento.FormaPagamento;

import java.util.Optional;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    Optional<FormaPagamento> findFormaPagamentoById(Long id);
    Optional<FormaPagamento> findFormaPagamentoByDescricao(String descricao);
}
