package restaurante.com.example.restauranteJava.entities.restaurante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import restaurante.com.example.restauranteJava.entities.cozinha.Cozinha;
import restaurante.com.example.restauranteJava.entities.endereco.Endereco;
import restaurante.com.example.restauranteJava.entities.formaPagamento.FormaPagamento;
import restaurante.com.example.restauranteJava.entities.produto.Produto;
import restaurante.com.example.restauranteJava.entities.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Restaurante {
    private String nome;
    private BigDecimal taxaFrete;
    private Boolean ativo;
    private Boolean aberto;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private Cozinha cozinha;
    private List<FormaPagamento> formasPagamento;
    private List<Usuario> responsaveis;
    private Endereco endereco;
    private List<Produto> produtos;

    public Restaurante(String nome, BigDecimal taxaFrete, Boolean ativo, Boolean aberto,
                       Cozinha cozinha, List<FormaPagamento> formasPagamento, List<Usuario> responsaveis,
                       Endereco endereco, List<Produto> produtos) {
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.cozinha = cozinha;
        this.formasPagamento = formasPagamento;
        this.responsaveis = responsaveis;
        this.endereco = endereco;
        this.produtos = produtos;

        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }
}
