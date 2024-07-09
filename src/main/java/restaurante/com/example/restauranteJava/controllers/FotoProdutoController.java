package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.FotoProdutoDTO;
import restaurante.com.example.restauranteJava.entities.produto.FotoProduto;
import restaurante.com.example.restauranteJava.service.FotoProdutoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fotoProduto")
public class FotoProdutoController {

    @Autowired
    private FotoProdutoService service;

    @PostMapping
    public ResponseEntity<FotoProduto> criarFotoProduto(@RequestBody FotoProdutoDTO data) throws Exception {
        FotoProduto fotoProduto = service.createFotoProduto(data);
        return new ResponseEntity<>(fotoProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FotoProduto>> getAllFotoProdutos(){
        List<FotoProduto> fotos = service.getAllFotoProduto();
        fotos.stream().forEach(x -> x.setProduto(null));
        return new ResponseEntity<>(fotos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFotoProdutoById(@PathVariable UUID id) throws Exception {
        this.service.deleteFotoProdutoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
