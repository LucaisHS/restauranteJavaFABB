package restaurante.com.example.restauranteJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.PermissaoDTO;
import restaurante.com.example.restauranteJava.entities.permissao.Permissao;
import restaurante.com.example.restauranteJava.repositories.PermissaoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PermissaoService {
    @Autowired
    private PermissaoRepository repository;

    public List<Permissao> getAllPermissao(){return repository.findAll();}
    public Permissao findPermissaoById(UUID id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("permissao não encontrada"));
    }

    public void savePermissao(Permissao permissao){
        repository.save(permissao);
    }

    public Permissao createPermissao(PermissaoDTO data){
        Permissao permissao = new Permissao(data);
        this.savePermissao(permissao);
        return permissao;
    }
}
