package restaurante.com.example.restauranteJava.entities.grupo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import restaurante.com.example.restauranteJava.entities.permissao.Permissao;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class Grupo {
    private String nome;
    private List<Permissao> permissoes = new ArrayList<Permissao>();

    public Grupo(String nome, List<Permissao> permissoes){
        this.nome = nome;
        for(int i = 0; i < permissoes.size(); i++) {
            this.permissoes.add(permissoes.get(i));
        }
    }
}
