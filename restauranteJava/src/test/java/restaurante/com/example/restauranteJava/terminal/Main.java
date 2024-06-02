package restaurante.com.example.restauranteJava.terminal;

import restaurante.com.example.restauranteJava.entities.cidade.Cidade;
import restaurante.com.example.restauranteJava.entities.cozinha.Cozinha;
import restaurante.com.example.restauranteJava.entities.endereco.Endereco;
import restaurante.com.example.restauranteJava.entities.estado.Estado;
import restaurante.com.example.restauranteJava.entities.formaPagamento.FormaPagamento;
import restaurante.com.example.restauranteJava.entities.grupo.Grupo;
import restaurante.com.example.restauranteJava.entities.pedido.ItemPedido;
import restaurante.com.example.restauranteJava.entities.pedido.Pedido;
import restaurante.com.example.restauranteJava.entities.permissao.Permissao;
import restaurante.com.example.restauranteJava.entities.produto.FotoProduto;
import restaurante.com.example.restauranteJava.entities.produto.Produto;
import restaurante.com.example.restauranteJava.entities.restaurante.Restaurante;
import restaurante.com.example.restauranteJava.entities.usuario.Usuario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //cozinhas
        Cozinha japonesa = new Cozinha("japonesa");
        Cozinha churrasco = new Cozinha("churrasco");

        //formas pagamentos
        FormaPagamento debito = new FormaPagamento("débito");
        FormaPagamento credito = new FormaPagamento("credito");
        List<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();
        formaPagamentos.add(debito);
        formaPagamentos.add(credito);

        // cidades e enderecos
        Cidade jundiai = new Cidade("jundiai", Estado.SP);
        Cidade varzea = new Cidade("Várzea Paulista", Estado.SP);
        Endereco end_restaurante1 = new Endereco("13207-771", "logradouro1", "123", "perto do terminal", "centro", jundiai);
        Endereco end_restaurante2 = new Endereco("13455-445", "logradouro2", "456", "praca alimentacao Shopping", "medeiros", varzea);
        Endereco end_cliente1 = new Endereco("11111-111", "logradouro3", "789", "casa com bananeira na frente", "jardim dos vales", jundiai);
        Endereco end_cliente2 = new Endereco("22222-222", "logradouro4", "101", "portão azul", "vila tupi", varzea);

        // permissoes & grupos
        Permissao permissao_dono = new Permissao("dono", "poder total");
        List<Permissao> permissoesDono = new ArrayList<Permissao>();
        permissoesDono.add(permissao_dono);
        Grupo grupoDono = new Grupo("dono", permissoesDono);

        Permissao permissao_cliente = new Permissao("cliente médio", "cancelar e criar pedidos");
        List<Permissao> permissoesCliente = new ArrayList<Permissao>();
        permissoesCliente.add(permissao_cliente);
        Grupo grupoCliente = new Grupo("Cliente médio", permissoesCliente);

        // usuarios
        Usuario dono1 = new Usuario("Lucas", "lucas@gmail.com", "0000", grupoDono);
        Usuario dono2 = new Usuario("Sophia", "sophia@gmail.com", "0001", grupoDono);
        List<Usuario> donos1 = new ArrayList<Usuario>();
        donos1.add(dono1);
        List<Usuario> donos2 = new ArrayList<Usuario>();
        donos2.add(dono1);
        donos2.add(dono2);

        Usuario cliente1 = new Usuario("Marluce", "marluce@gmail.com", "aaa", grupoCliente);
        Usuario cliente2 = new Usuario("Pietra", "pietra@gmail.com", "bbbb", grupoCliente);

        // BigDecimals
        BigDecimal precoPicanha = new BigDecimal("40");
        BigDecimal precoSushi = new BigDecimal("30");
        BigDecimal precoFrete = new BigDecimal("10");
        BigDecimal frete = new BigDecimal("9.90");

        // Produto
        FotoProduto foto1 = new FotoProduto("sushi", "foto sushi", "linkImg");
        Produto sushi = new Produto("Sushi", "Delicioso sushi", precoSushi, true, foto1);
        FotoProduto foto2 = new FotoProduto("picanha", "foto picanha", "linkImg");
        Produto picanha = new Produto("Picanha", "Deliciosa picanha", precoPicanha, true, foto2);
        List<Produto> produtosLoja1 = new ArrayList<Produto>();
        produtosLoja1.add(sushi);
        List<Produto> produtosLoja2 = new ArrayList<Produto>();
        produtosLoja2.add(picanha);

        // Restaurante
        Restaurante restaurante1 = new Restaurante("japoExpress", precoFrete, true, true, japonesa, formaPagamentos, donos1, end_restaurante1, produtosLoja1);
        Restaurante restaurante2 = new Restaurante("Picanharia Brasas", precoFrete, true, true, churrasco, formaPagamentos, donos2, end_restaurante2, produtosLoja2);

        // ItemPedido
        Integer quantidade = 2;
        ItemPedido itemPedido1 = new ItemPedido(quantidade, precoSushi, "", sushi);
        List<ItemPedido> itens1 = new ArrayList<ItemPedido>();
        itens1.add(itemPedido1);

        Integer quantidade2 = 3;
        ItemPedido itemPedido2 = new ItemPedido(quantidade2, precoPicanha, "ao ponto", picanha);
        List<ItemPedido> itens2 = new ArrayList<ItemPedido>();
        itens2.add(itemPedido2);

        // Pedido
        Pedido pedido1 = new Pedido(itemPedido1.getPrecoTotal(), frete, end_cliente1, cliente1, restaurante1, debito, itens1);
        Pedido pedido2 = new Pedido(itemPedido2.getPrecoTotal(), frete, end_cliente2, cliente2, restaurante2, credito, itens2);
        System.out.println("Pedidos: ");
        System.out.println("pedido 1: ");
        System.out.println(pedido1);
        System.out.println("");
        System.out.println("pedido 2:");
        System.out.println(pedido2);

        System.out.println("==========================================================");
        System.out.println("confirmando pedido");
        pedido1.confirmaPedido();
        System.out.println(pedido1);
        System.out.println("pedido 1: ");
        System.out.println("entrega confirmada");
        pedido1.confirmaEntrega();
        System.out.println("pedido 1: ");
        System.out.println(pedido1);

        System.out.println("================================================================");
        System.out.println("pedido 2 cancelado: ");
        pedido2.cancelarPedido();
        System.out.println("pedido 2: ");
        System.out.println(pedido2);

        System.out.println("Em resumo: ");
        System.out.println("pedido 1 => " + pedido1.getStatus());
        System.out.println("pedido 2 => " +pedido2.getStatus());



    }
}
