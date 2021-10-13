package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CampoUnico;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @ApiModelProperty(position = 1, example = "Brasil", required = true)
    @NotBlank
    @CampoUnico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais converter() {
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }
}
