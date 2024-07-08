package restaurante.com.example.restauranteJava.entities.produto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.dtos.FotoProdutoDTO;

import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "fotoProduto")
@Table(name = "fotoProduto")
public class FotoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;
    private String contentType;
    private Long tamanho;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonManagedReference
    private Produto produto;

    public FotoProduto(String nome, String descricao, String contentType){
        this.nome = nome;
        this.descricao = descricao;
        this.contentType = contentType;
        calculaTamanho();
    }

    private void calculaTamanho() {
        //
        this.tamanho = 124L;
    }

    public FotoProduto(FotoProdutoDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.contentType = data.contentType();
        this.tamanho = data.tamanho();
    }
}
