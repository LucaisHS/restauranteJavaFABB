package restaurante.com.example.restauranteJava.entities.produto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.dtos.FotoProdutoDTO;
import restaurante.com.example.restauranteJava.dtos.ProdutoDTO;
import restaurante.com.example.restauranteJava.dtos.ProdutoResponseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "produto")
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonBackReference
    private List<FotoProduto> foto;

    public Produto(ProdutoDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.preco = data.preco();
        this.ativo = data.ativo();
    }

}
