package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CampoUnico;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @ApiModelProperty(position = 1, example = "Jacob", required = true)
    @NotBlank
    private String nome;

    @ApiModelProperty(position = 2, example = "jacob@email.com", required = true)
    @NotBlank
    @Email
    @CampoUnico(domainClass = Autor.class, fieldName = "email")
    private String email;

    @ApiModelProperty(position = 3, example = "Like to write", required = true)
    @NotBlank
    @Size(min = 1, max = 400)
    private String descricao;


    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
