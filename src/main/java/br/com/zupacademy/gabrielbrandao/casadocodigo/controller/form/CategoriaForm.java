package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;


import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CategoriaUnica;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @CategoriaUnica
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
