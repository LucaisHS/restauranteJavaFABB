package restaurante.com.example.restauranteJava.entities.grupo;

import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.entities.permissao.Permissao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "grupo")

public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "grupo_id")
    private List<Permissao> permissoes = new ArrayList<Permissao>();

    public Grupo(String nome, List<Permissao> permissoes){
        this.nome = nome;
        for(int i = 0; i < permissoes.size(); i++) {
            this.permissoes.add(permissoes.get(i));
        }
    }
}
