package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.ProdutoDTO;
import restaurante.com.example.restauranteJava.dtos.ProdutoResponseDTO;
import restaurante.com.example.restauranteJava.entities.produto.FotoProduto;
import restaurante.com.example.restauranteJava.entities.produto.Produto;
import restaurante.com.example.restauranteJava.service.FotoProdutoService;
import restaurante.com.example.restauranteJava.service.ProdutoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private FotoProdutoService fotoProdutoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoDTO data) throws Exception {
        List<FotoProduto> fotos = new ArrayList<>();

        data.fotos().stream().forEach(x -> {
            try {
                fotos.add(fotoProdutoService.findFotoProdutoById(x));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Produto produto = produtoService.createProduto(data, fotos); // aqui
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> produtos = produtoService.getAllProdutos();
        //produtos.stream().forEach(x -> x.setFoto(null));

        //System.out.println(produtos.get(0));



        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

}
