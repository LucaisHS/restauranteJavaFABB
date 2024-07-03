package restaurante.com.example.restauranteJava.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.UsuarioDTO;
import restaurante.com.example.restauranteJava.entities.usuario.Usuario;
import restaurante.com.example.restauranteJava.repositories.UsuarioRepository;

import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findUsuarioById(UUID id) throws Exception {
        return this.repository.findUsuarioById(id)
                .orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void saveUsuario(Usuario usuario){
        this.repository.save(usuario);
    }

    public Usuario createUsuario(UsuarioDTO usuario){
        Usuario novoUsuario = new Usuario(usuario);
        saveUsuario(novoUsuario);
        return novoUsuario;
    }
}
