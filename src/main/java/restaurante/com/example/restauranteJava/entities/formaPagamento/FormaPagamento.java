package restaurante.com.example.restauranteJava.entities.formaPagamento;

import jakarta.persistence.*;
import lombok.*;
import restaurante.com.example.restauranteJava.dtos.FormaPagamentoDTO;

import java.util.UUID;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "formaPagamento")
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;

    public FormaPagamento(FormaPagamentoDTO data){
        this.descricao = data.descricao();
    }
}
