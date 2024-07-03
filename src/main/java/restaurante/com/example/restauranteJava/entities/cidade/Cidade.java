package restaurante.com.example.restauranteJava.entities.cidade;

import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.dtos.CidadeDTO;
import restaurante.com.example.restauranteJava.entities.estado.Estado;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Cidade(CidadeDTO data){
        this.nome = data.nome();
        this.estado = data.estado();
    }
}
