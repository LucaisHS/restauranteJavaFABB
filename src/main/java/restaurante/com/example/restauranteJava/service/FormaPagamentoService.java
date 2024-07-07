package restaurante.com.example.restauranteJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante.com.example.restauranteJava.dtos.FormaPagamentoDTO;
import restaurante.com.example.restauranteJava.entities.formaPagamento.FormaPagamento;
import restaurante.com.example.restauranteJava.repositories.FormaPagamentoRepository;

import java.util.List;

@Service
public class FormaPagamentoService {
    @Autowired
    FormaPagamentoRepository repository;

    public void saveFormaPagamento(FormaPagamento formaPagamento){
        repository.save(formaPagamento);
    }

    public FormaPagamento findFormaPagamentoById(Long id) throws Exception {
        return repository.findFormaPagamentoById(id).orElseThrow(() -> new Exception("Forma de pagamento não encotrada"));
    }

    public FormaPagamento createFormaPagamento(FormaPagamentoDTO data){
        FormaPagamento novaFormaPagamento = new FormaPagamento(data);
        this.saveFormaPagamento(novaFormaPagamento);
        return novaFormaPagamento;
    }

    public List<FormaPagamento> getAllFormaPagamentos(){
        return this.repository.findAll();
    }

}
