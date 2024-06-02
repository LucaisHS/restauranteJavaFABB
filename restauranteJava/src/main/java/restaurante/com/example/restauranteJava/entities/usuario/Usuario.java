package restaurante.com.example.restauranteJava.entities.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import restaurante.com.example.restauranteJava.entities.grupo.Grupo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private List<Grupo> grupos = new ArrayList<Grupo>();

    public Usuario(String nome, String email, String senha, Grupo grupo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.grupos.add(grupo);
        this.dataCadastro = LocalDateTime.now();
    }
}
