package restaurante.com.example.restauranteJava.dtos;

import java.util.UUID;

public record FotoProdutoDTO(UUID id, String nome, String descricao, String contentType, Long tamanho, UUID produtoId) {
}
