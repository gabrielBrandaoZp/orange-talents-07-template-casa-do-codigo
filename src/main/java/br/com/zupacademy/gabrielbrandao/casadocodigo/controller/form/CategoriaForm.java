package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;


import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CampoUnico;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @ApiModelProperty(position = 1, example = "Drama", required = true)
    @NotBlank
    @CampoUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
