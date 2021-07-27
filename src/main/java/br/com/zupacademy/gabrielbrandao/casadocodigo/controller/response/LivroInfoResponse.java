package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroInfoResponse {

    private long id;
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
