package restaurante.com.example.restauranteJava.entities.cidade;

import lombok.AllArgsConstructor;
import lombok.ToString;
import restaurante.com.example.restauranteJava.entities.estado.Estado;

@AllArgsConstructor
@ToString
public class Cidade {
    private String nome;
    private Estado estado;

}
