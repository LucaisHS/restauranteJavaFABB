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

    @Autowired
    private FotoProdutoService fotoProdutoService;

    public Produto findProdutoByContaId(UUID id) throws Exception{
        return this.repository.findProdutoById(id).orElseThrow(() -> new Exception("Produto não encontrada"));
    }

    public void saveProduto(Produto produto){
        this.repository.save(produto);
    }

    public Produto createProduto(ProdutoDTO data) throws Exception {

        List<FotoProduto> fotos = new ArrayList<>();

        data.fotos().stream().forEach(x -> {
            try {
                fotos.add(fotoProdutoService.findFotoProdutoById(x));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Produto novoProduto = new Produto(data);
        novoProduto.setFoto(fotos);
        this.saveProduto(novoProduto);
        return novoProduto;
    }

//    public List<ProdutoResponseDTO> getAllProdutos() {
//        List<Produto> produtos = repository.findAll();
//
//        return produtos.stream().map(produto -> {
//            List<FotoProdutoDTO> fotos = produto.getFoto().stream()
//                    .map(foto -> new FotoProdutoDTO(
//                            foto.getId(), // Certifique-se de incluir o ID aqui
//                            foto.getNome(),
//                            foto.getDescricao(),
//                            foto.getContentType(),
//                            foto.getTamanho()
//                    ))
//                    .collect(Collectors.toList());
//
//            return new ProdutoResponseDTO(
//                    produto.getId(),
//                    produto.getNome(),
//                    produto.getDescricao(),
//                    produto.getPreco(),
//                    produto.getAtivo(),
//                    fotos
//            );
//        }).collect(Collectors.toList());
//    }

    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }
}
