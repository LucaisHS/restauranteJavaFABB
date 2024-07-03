package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.EnderecoDTO;
import restaurante.com.example.restauranteJava.entities.endereco.Endereco;
import restaurante.com.example.restauranteJava.service.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    EnderecoService service;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoDTO data) throws Exception {
        Endereco endereco = service.createEndereco(data);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEndereco(){
        List<Endereco> enderecos = service.getAllEndereco();
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }
}
