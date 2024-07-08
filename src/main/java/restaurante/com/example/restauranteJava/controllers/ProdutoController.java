package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.ProdutoDTO;
import restaurante.com.example.restauranteJava.dtos.ProdutoResponseDTO;
import restaurante.com.example.restauranteJava.entities.produto.Produto;
import restaurante.com.example.restauranteJava.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoDTO data) throws Exception {
        Produto produto = produtoService.createProduto(data);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<ProdutoResponseDTO>> getAllProdutos(){
//        List<ProdutoResponseDTO> produtos = produtoService.getAllProdutos();
//        return new ResponseEntity<>(produtos, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> produtos = produtoService.getAllProdutos();
        System.out.println(produtos.get(0));
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

}
