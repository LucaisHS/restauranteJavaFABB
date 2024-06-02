package restaurante.com.example.restauranteJava.entities.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Produto {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;
    private FotoProduto foto;
}
