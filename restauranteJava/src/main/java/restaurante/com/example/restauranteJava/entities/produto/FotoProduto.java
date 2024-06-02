package restaurante.com.example.restauranteJava.entities.produto;


import lombok.ToString;

@ToString
public class FotoProduto {
    private String nome;
    private String descricao;
    private String contentType;
    private Long tamanho;

    public FotoProduto(String nome, String descricao, String contentType){
        this.nome = nome;
        this.descricao = descricao;
        this.contentType = contentType;
        calculaTamanho();
    }

    private void calculaTamanho() {
        //
        this.tamanho = 124L;
    }
}
