package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import io.swagger.annotations.ApiModelProperty;

public class AutorResponse {

    @ApiModelProperty(position = 1, example = "1")
    private Long id;

    @ApiModelProperty(position = 2, example = "Jacob")
    private String nome;

    @ApiModelProperty(position = 3, example = "Like to write")
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
