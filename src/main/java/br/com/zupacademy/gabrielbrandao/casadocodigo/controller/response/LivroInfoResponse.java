package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroInfoResponse {

    @ApiModelProperty(position = 1, example = "1")
    private long id;

    @ApiModelProperty(position = 2, example = "Clean code")
    private String nome;

    public LivroInfoResponse(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static List<LivroInfoResponse> converter(List<Livro> livros) {
        List<LivroInfoResponse> livrosInfo = new ArrayList<>();
        livrosInfo.addAll(livros.stream().map(livro -> new LivroInfoResponse(livro.getId(), livro.getTitulo())).collect(Collectors.toList()));
        return livrosInfo;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
