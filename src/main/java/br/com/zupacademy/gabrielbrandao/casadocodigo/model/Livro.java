package br.com.zupacademy.gabrielbrandao.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
}
