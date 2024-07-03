package restaurante.com.example.restauranteJava.entities.pedido;

import lombok.*;
import restaurante.com.example.restauranteJava.entities.endereco.Endereco;
import restaurante.com.example.restauranteJava.entities.formaPagamento.FormaPagamento;
import restaurante.com.example.restauranteJava.entities.restaurante.Restaurante;
import restaurante.com.example.restauranteJava.entities.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@ToString
@Getter
@Setter
public class Pedido {
    private static Integer proxCodigo = 0;
    private String codigo;
    private BigDecimal subtotal;
    private BigDecimal taxaFrete;
    private BigDecimal valorTotal;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConfirmacao;
    private LocalDateTime dataEntregue;
    private LocalDateTime dataCancelamento;
    private StatusPedido status;
    private Endereco enderecoEntrega;
    private Usuario cliente;
    private Restaurante restaurante;
    private FormaPagamento formaPagamento;
    private List<ItemPedido> itens;

    public Pedido(BigDecimal subtotal, BigDecimal taxaFrete, Endereco enderecoEntrega, Usuario cliente, Restaurante restaurante, FormaPagamento formaPagamento, List<ItemPedido> itens) {
        this.subtotal = subtotal;
        this.taxaFrete = taxaFrete;
        this.enderecoEntrega = enderecoEntrega;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.formaPagamento = formaPagamento;
        this.itens = itens;

        this.codigo = novoCodigo();
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusPedido.CRIADO;
        this.valorTotal = subtotal.add(taxaFrete);
    }

    public Pedido(){
        this.codigo = novoCodigo();
        this.status = StatusPedido.CRIADO;
    }

    private String novoCodigo(){
        Integer novoCodigo = Pedido.proxCodigo;
        Pedido.proxCodigo += 1;
        return "" + novoCodigo;
    }

    public void cancelarPedido(){
        this.status = StatusPedido.CANCELADO;
        this.dataCancelamento = LocalDateTime.now();
    }

    public void confirmaPedido(){
        this.status = StatusPedido.CONFIRMADO;
        this.dataConfirmacao = LocalDateTime.now();
    }

    public void confirmaEntrega(){
        this.status = StatusPedido.ENTREGUE;
        this.dataEntregue = LocalDateTime.now();
    }

}
