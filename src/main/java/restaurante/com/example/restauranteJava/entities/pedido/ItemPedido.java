package restaurante.com.example.restauranteJava.entities.pedido;

import lombok.*;
import restaurante.com.example.restauranteJava.entities.produto.Produto;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemPedido {
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private String observacao;
    private Produto produto;

    public ItemPedido(Integer quantidade, BigDecimal precoUnitario, String observacao, Produto produto){
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.observacao = observacao;
        this.produto = produto;
        this.precoTotal = calculaPrecoTotal(quantidade, precoUnitario);
    }

    private BigDecimal calculaPrecoTotal(Integer quantidade, BigDecimal precoUnitario) {
        BigDecimal temp = BigDecimal.valueOf(quantidade);
        return precoUnitario.multiply(temp);
    }
}
