package restaurante.com.example.restauranteJava.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProdutoResponseDTO(UUID id, String nome, String descricao, BigDecimal preco, Boolean ativo, List<FotoProdutoDTO> fotos) {
}
