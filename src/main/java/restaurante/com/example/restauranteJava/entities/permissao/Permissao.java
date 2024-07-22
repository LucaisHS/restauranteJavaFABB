package restaurante.com.example.restauranteJava.entities.permissao;

import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.dtos.PermissaoDTO;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "permissao")
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;

    public Permissao(PermissaoDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
    }
}
