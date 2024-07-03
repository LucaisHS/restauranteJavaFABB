package restaurante.com.example.restauranteJava.dtos;

import restaurante.com.example.restauranteJava.entities.cidade.Cidade;

import java.util.UUID;

public record EnderecoDTO(String cep, String logradouro, String numero, String complemento, String bairro, UUID cidade) {
}
