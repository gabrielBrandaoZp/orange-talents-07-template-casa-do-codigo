package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CampoUnico;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.ExisteId;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {

    @NotBlank
    @CampoUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numPaginas;

    @NotBlank
    @CampoUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataLancamento;

    @ExisteId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    @ExisteId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    @NotBlank
    private String sumario;

    public LivroForm(String titulo, String resumo, BigDecimal preco, Integer numPaginas, String isbn, LocalDate dataLancamento,
                     Long categoriaId, Long autorId, String sumario) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
        this.sumario = sumario;
    }

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autorObj = autorRepository.findById(this.autorId);
        Optional<Categoria> categoriaObj = categoriaRepository.findById(this.categoriaId);

        @NotNull Autor autor = autorObj.get();
        @NotNull Categoria categoria = categoriaObj.get();

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numPaginas, this.isbn, this.dataLancamento, categoria, autor);
    }

}
