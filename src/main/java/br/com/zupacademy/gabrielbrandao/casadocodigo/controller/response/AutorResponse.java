package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;

public class AutorResponse {

    private Long id;
    private String nome;
    private String descricao;

    public AutorResponse(Autor autor) {
        id = autor.getId();
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
