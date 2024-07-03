package restaurante.com.example.restauranteJava.entities.usuario;

import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.dtos.UsuarioDTO;
import restaurante.com.example.restauranteJava.entities.grupo.Grupo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;

    @ManyToMany
    @JoinTable(
            name = "usuario_grupo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private List<Grupo> grupos = new ArrayList<>();

    public Usuario(String nome, String email, String senha, Grupo grupo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.grupos.add(grupo);
        this.dataCadastro = LocalDateTime.now();
    }

    public Usuario(UsuarioDTO data){

    }
}
