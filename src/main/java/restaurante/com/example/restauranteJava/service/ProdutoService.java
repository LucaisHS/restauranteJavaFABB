package restaurante.com.example.restauranteJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.FotoProdutoDTO;
import restaurante.com.example.restauranteJava.dtos.ProdutoDTO;
import restaurante.com.example.restauranteJava.dtos.ProdutoResponseDTO;
import restaurante.com.example.restauranteJava.entities.produto.FotoProduto;
import restaurante.com.example.restauranteJava.entities.produto.Produto;
import restaurante.com.example.restauranteJava.repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;


    public Produto findProdutoByContaId(UUID id) throws Exception{
        return this.repository.findProdutoById(id).orElseThrow(() -> new Exception("Produto não encontrada"));
    }

    public void saveProduto(Produto produto){
        this.repository.save(produto);
    }

    public Produto createProduto(ProdutoDTO data, List<FotoProduto> fotos){
        Produto novoProduto = new Produto(data);
        novoProduto.setFoto(fotos);
        this.saveProduto(novoProduto);
        return novoProduto;
    }

    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }
}
