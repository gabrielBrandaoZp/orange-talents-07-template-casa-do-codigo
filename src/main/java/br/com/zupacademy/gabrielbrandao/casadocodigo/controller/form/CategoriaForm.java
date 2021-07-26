package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;


import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CampoUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

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
