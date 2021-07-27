package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class LivroDetalhesResponse {

    private long id;
    private String titulo;
    private String sumario;
    private String isbn;
    private AutorResponse autor;
    private String resumo;
    private BigDecimal preco;
    private Integer numPaginas;
    private String dataLancamento;

    public LivroDetalhesResponse(Livro livro) {
        id = livro.getId();
        titulo = livro.getTitulo();
        sumario = livro.getSumario();
        isbn = livro.getIsbn();
        resumo = livro.getResumo();
        preco = livro.getPreco();
        numPaginas = livro.getNumPaginas();
        dataLancamento = livro.getDataFormatada("dd/MM/yyyy");
        autor = new AutorResponse(livro.getAutor());
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorResponse getAutor() {
        return autor;
    }

    public String getResumo() {
        return resumo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }
}
