package br.com.zupacademy.gabrielbrandao.casadocodigo.model.builder;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Cliente;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Pais;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class ClienteBuilder {

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Pais pais;
    private String telefone;
    private String cep;

    public ClienteBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public ClienteBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder comSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public ClienteBuilder comDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public ClienteBuilder comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public ClienteBuilder comComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public ClienteBuilder comCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public ClienteBuilder comPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    public ClienteBuilder comTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public ClienteBuilder comCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Cliente constroi() {
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
    }
}
