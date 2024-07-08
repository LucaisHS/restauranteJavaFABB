package restaurante.com.example.restauranteJava.dtos;

import restaurante.com.example.restauranteJava.entities.produto.FotoProduto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProdutoDTO(String nome, String descricao, BigDecimal preco, Boolean ativo, List<UUID> fotos) {
}
