package restaurante.com.example.restauranteJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurante.com.example.restauranteJava.dtos.FormaPagamentoDTO;
import restaurante.com.example.restauranteJava.entities.formaPagamento.FormaPagamento;
import restaurante.com.example.restauranteJava.service.FormaPagamentoService;

import java.util.List;

@RestController
@RequestMapping("/FormaPagamento")
public class FormaPagamentoController {
    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping
    public ResponseEntity<FormaPagamento> criarFormaPagamento(@RequestBody FormaPagamentoDTO FormaPagamento){
        FormaPagamento novaFormaPagamento = formaPagamentoService.createFormaPagamento(FormaPagamento);
        return new ResponseEntity<>(novaFormaPagamento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> getAllFormaPagamentos() {
        List<FormaPagamento> formaPagamentos = formaPagamentoService.getAllFormaPagamentos();
        return new ResponseEntity<>(formaPagamentos, HttpStatus.OK);
    }
}
