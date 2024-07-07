package restaurante.com.example.restauranteJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.CozinhaDTO;
import restaurante.com.example.restauranteJava.entities.cozinha.Cozinha;
import restaurante.com.example.restauranteJava.repositories.CozinhaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CozinhaService {
    @Autowired
    private CozinhaRepository repository;

    public Cozinha findCozinhaById(UUID id) throws Exception {
        return repository.findCozinhaById(id).orElseThrow(() -> new Exception("Cozinha não encontrada"));
    }

    public void saveCozinha(Cozinha cozinha){
        repository.save(cozinha);
    }

    public Cozinha createCozinha(CozinhaDTO data){
        Cozinha cozinha = new Cozinha(data);
        this.saveCozinha(cozinha);
        return cozinha;
    }

    public List<Cozinha> getAllCozinha(){
        return repository.findAll();
    }
}
