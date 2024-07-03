package restaurante.com.example.restauranteJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.CidadeDTO;
import restaurante.com.example.restauranteJava.entities.cidade.Cidade;
import restaurante.com.example.restauranteJava.repositories.CidadeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository repository;

    public Cidade findCidadeById(UUID id) throws Exception {
        return repository.findCidadeById(id).orElseThrow(() -> new Exception("Cidade não encontrada"));
    }

    public void saveCidade (Cidade cidade){
        repository.save(cidade);
    }

    public Cidade createCidade(CidadeDTO data){
        Cidade newCidade = new Cidade(data);
        saveCidade(newCidade);
        return newCidade;
    }

    public List<Cidade> getAllCidade(){
        return repository.findAll();
    }
}
