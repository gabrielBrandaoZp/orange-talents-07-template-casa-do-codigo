package br.com.zupacademy.gabrielbrandao.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String sumario;

    @Column(unique = true)
    private String isbn;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    @Column(columnDefinition = "TEXT")
    private String resumo;

    private LocalDate dataLancamento;

    private BigDecimal preco;

    private Integer numPaginas;

    @Deprecated
    public Livro() {}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numPaginas, String isbn, LocalDate dataLancamento,
                 Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
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

    public Autor getAutor() {
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

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public String getDataFormatada(String estilo) {
        return dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyy"));
    }
}
