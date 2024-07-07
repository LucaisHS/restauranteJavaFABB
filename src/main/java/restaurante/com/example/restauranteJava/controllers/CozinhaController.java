package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.CozinhaDTO;
import restaurante.com.example.restauranteJava.entities.cozinha.Cozinha;
import restaurante.com.example.restauranteJava.service.CozinhaService;

import java.util.List;

@RestController
@RequestMapping("/cozinha")
public class CozinhaController {
    @Autowired
    CozinhaService cozinhaService;

    @PostMapping
    public ResponseEntity<Cozinha> criarCozinha(@RequestBody CozinhaDTO cozinha){
        Cozinha novaCozinha = cozinhaService.createCozinha(cozinha);
        return new ResponseEntity<>(novaCozinha, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cozinha>> getAllCozinhas(){
        List<Cozinha> cozinhas = this.cozinhaService.getAllCozinha();
        return new ResponseEntity<>(cozinhas, HttpStatus.OK);
    }
}
