package br.com.zupacademy.gabrielbrandao.casadocodigo.model.builder;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroBuilder {

    private String titulo;
    private String sumario;
    private String isbn;
    private Categoria categoria;
    private Autor autor;
    private String resumo;
    private LocalDate dataLancamento;
    private BigDecimal preco;
    private Integer numPaginas;

    public LivroBuilder() {
    }

    public LivroBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder comSumario(String sumario) {
        this.sumario = sumario;
        return this;
    }

    public LivroBuilder comIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LivroBuilder comCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public LivroBuilder comAutor(Autor autor) {
        this.autor = autor;
        return this;
    }

    public LivroBuilder comResumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public LivroBuilder comDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    public LivroBuilder comPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public LivroBuilder comNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
        return this;
    }

    public Livro constroi() {
        return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataLancamento, categoria, autor);
    }
}
