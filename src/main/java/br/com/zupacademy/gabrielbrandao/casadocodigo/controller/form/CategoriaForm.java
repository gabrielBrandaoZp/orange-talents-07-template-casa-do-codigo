package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;


import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
