package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.CidadeDTO;
import restaurante.com.example.restauranteJava.entities.cidade.Cidade;
import restaurante.com.example.restauranteJava.service.CidadeService;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> criarCidade(@RequestBody CidadeDTO cidade){
        Cidade newCidade = cidadeService.createCidade(cidade);
        return new ResponseEntity<>(newCidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> getAllCidade(){
        List<Cidade> cidades = cidadeService.getAllCidade();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }
}
