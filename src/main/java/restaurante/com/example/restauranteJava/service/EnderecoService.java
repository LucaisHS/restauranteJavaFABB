package restaurante.com.example.restauranteJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.EnderecoDTO;
import restaurante.com.example.restauranteJava.entities.cidade.Cidade;
import restaurante.com.example.restauranteJava.entities.endereco.Endereco;
import restaurante.com.example.restauranteJava.repositories.CidadeRepository;
import restaurante.com.example.restauranteJava.repositories.EnderecoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository repository;

    @Autowired
    CidadeService cidadeService;

    public Endereco findEnderecoById(UUID id) throws Exception {
        return repository.findEnderecoById(id).orElseThrow(()-> new Exception("endereco não encotrado"));
    }

    public void saveEndereco(Endereco endereco){
        repository.save(endereco);
    }

    public Endereco createEndereco(EnderecoDTO data) throws Exception {
        Cidade cidade = cidadeService.findCidadeById(data.cidade());
        Endereco endereco = new Endereco(data);
        endereco.setCidade(cidade);
        saveEndereco(endereco);
        return endereco;
    }

    public List<Endereco> getAllEndereco(){
        return repository.findAll();
    }
}
