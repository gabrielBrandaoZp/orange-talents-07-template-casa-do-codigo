package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.builder.LivroBuilder;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CampoUnico;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.ExisteId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {

    @ApiModelProperty(position = 1, example = "Clean code", required = true)
    @NotBlank
    @CampoUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @ApiModelProperty(position = 2, example = "Some random resume", required = true)
    @NotBlank
    @Size(max = 500)
    private String resumo;

    @ApiModelProperty(position = 3, example = "59.90", required = true)
    @NotNull
    @Min(20)
    private BigDecimal preco;

    @ApiModelProperty(position = 4, example = "455", required = true)
    @NotNull
    @Min(100)
    private Integer numPaginas;

    @ApiModelProperty(position = 5, example = "321323-678", required = true)
    @NotBlank
    @CampoUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @ApiModelProperty(position = 6, example = "20/02/1990", required = true)
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @ApiModelProperty(position = 7, example = "1", required = true)
    @ExisteId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    @ApiModelProperty(position = 8, example = "1", required = true)
    @ExisteId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    @ApiModelProperty(position = 9, example = "Some random summary", required = true)
    @NotBlank
    private String sumario;

    public LivroForm(String titulo, String resumo, BigDecimal preco, Integer numPaginas, String isbn,
                     Long categoriaId, Long autorId, String sumario) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
        this.sumario = sumario;
    }

    /*
       O método foi criado para que seja possível desserializar a data com o pattern passado dd/MM/yyyy,
       sem ele não é possível.
     */
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Optional<Livro> converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autorObj = autorRepository.findById(this.autorId);
        Optional<Categoria> categoriaObj = categoriaRepository.findById(this.categoriaId);

        Autor autor = autorObj.get();
        Categoria categoria = categoriaObj.get();

        return Optional.of(
                new LivroBuilder()
                .comTitulo(this.titulo)
                .comResumo(this.resumo)
                .comSumario(this.sumario)
                .comPreco(this.preco)
                .comNumPaginas(this.numPaginas)
                .comIsbn(this.isbn)
                .comDataLancamento(this.dataLancamento)
                .comCategoria(categoria)
                .comAutor(autor)
                .constroi());
    }

    public String getTitulo() {
        return titulo;
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

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public String getSumario() {
        return sumario;
    }
}
