package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.PermissaoDTO;
import restaurante.com.example.restauranteJava.entities.permissao.Permissao;
import restaurante.com.example.restauranteJava.service.PermissaoService;

import java.util.List;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {
    @Autowired
    private PermissaoService service;

    @PostMapping
    public ResponseEntity<Permissao> criarPermissao(@RequestBody PermissaoDTO data){
        Permissao permissao =  service.createPermissao(data);
        return new ResponseEntity<>(permissao, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Permissao>> getAllPermissao(){
        List<Permissao> permissoes = this.service.getAllPermissao();
        return new ResponseEntity<>(permissoes, HttpStatus.OK);
    }
}
