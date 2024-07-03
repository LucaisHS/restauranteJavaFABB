package restaurante.com.example.restauranteJava.entities.endereco;

import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.entities.cidade.Cidade;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @OneToOne
    private Cidade cidade;

}
