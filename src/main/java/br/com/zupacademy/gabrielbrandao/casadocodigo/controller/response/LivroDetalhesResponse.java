package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class LivroDetalhesResponse {

    @ApiModelProperty(position = 1, example = "1")
    private long id;

    @ApiModelProperty(position = 2, example = "Clean code")
    private String titulo;

    @ApiModelProperty(position = 3, example = "RANDOM SUMMARY")
    private String sumario;

    @ApiModelProperty(position = 4, example = "43423434-1233")
    private String isbn;

    @ApiModelProperty(position = 5, example = "Autor response")
    private AutorResponse autor;

    @ApiModelProperty(position = 6, example = "Bom livro para leitura")
    private String resumo;

    @ApiModelProperty(position = 7, example = "59.90")
    private BigDecimal preco;

    @ApiModelProperty(position = 8, example = "455")
    private Integer numPaginas;

    @ApiModelProperty(position = 9, example = "20/02/1990")
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
