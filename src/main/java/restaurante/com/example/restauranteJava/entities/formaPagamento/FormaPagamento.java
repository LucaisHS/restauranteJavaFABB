package restaurante.com.example.restauranteJava.entities.formaPagamento;

import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
}
