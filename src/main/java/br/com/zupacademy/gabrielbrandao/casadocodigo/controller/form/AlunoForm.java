package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Aluno;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AlunoForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 400)
    private String descricao;


    public AlunoForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Aluno converter() {
        return new Aluno(this.nome, this.email, this.descricao);
    }
}
