package restaurante.com.example.restauranteJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.FotoProdutoDTO;
import restaurante.com.example.restauranteJava.entities.produto.FotoProduto;
import restaurante.com.example.restauranteJava.entities.produto.Produto;
import restaurante.com.example.restauranteJava.repositories.FotoProdutoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FotoProdutoService {
    @Autowired
    private FotoProdutoRepository repository;

    @Autowired
    private ProdutoService produtoService;

    public FotoProduto findFotoProdutoById(UUID id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("foto não encontrada"));
    }

    public void saveFotoProduto(FotoProduto foto){
        repository.save(foto);
    }

    public FotoProduto createFotoProduto(FotoProdutoDTO data) throws Exception {
        FotoProduto fotoProduto = new FotoProduto(data);
        Produto newProduto = produtoService.findProdutoByContaId(data.produtoId());
        fotoProduto.setProduto(newProduto);
        this.saveFotoProduto(fotoProduto);
        return fotoProduto;
    }

    public List<FotoProduto> getAllFotoProduto(){
        return repository.findAll();
    }

    public List<FotoProduto> getAllFotoProdutoByProdutoId(UUID id) throws Exception {
        return repository.findAllByProduto_Id(id).orElseThrow(() -> new Exception("nenhuma foto com o id especificado na função"));
    }

    public void deleteFotoProdutoById(UUID id) throws Exception {
        FotoProduto fotoProduto = repository.findById(id).orElseThrow(() -> new Exception("usuario não existe"));
        repository.delete(fotoProduto);
    }
}
