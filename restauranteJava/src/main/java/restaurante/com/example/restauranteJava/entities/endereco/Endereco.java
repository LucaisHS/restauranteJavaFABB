package restaurante.com.example.restauranteJava.entities.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import restaurante.com.example.restauranteJava.entities.cidade.Cidade;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;
}
