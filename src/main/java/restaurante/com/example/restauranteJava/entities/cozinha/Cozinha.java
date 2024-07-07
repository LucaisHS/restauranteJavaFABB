package restaurante.com.example.restauranteJava.entities.cozinha;

import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.dtos.CozinhaDTO;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cozinha")
public class Cozinha {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;

    public Cozinha(CozinhaDTO data) {
        this.nome = data.nome();
    }
}
