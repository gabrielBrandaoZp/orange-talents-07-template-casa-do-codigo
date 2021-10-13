package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.exception.ErrorForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response.LivroDetalhesResponse;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response.LivroInfoResponse;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.LivroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
@Api(tags = "Livro Controller")
public class LivroController {

    private LivroRepository repository;
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository repository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @ApiOperation(value = "Lista todos os livros")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = LivroInfoResponse.class),
    })
    @GetMapping
    public ResponseEntity<List<LivroInfoResponse>> livros() {
        List<Livro> livros = repository.findAll();
        List<LivroInfoResponse> livrosInfo = LivroInfoResponse.converter(livros);
        return ResponseEntity.ok().body(livrosInfo);
    }

    @ApiOperation(value = "Lista informações de um livro a partir do seu id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = LivroDetalhesResponse.class),
    })
    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesResponse> livroPorId(@PathVariable Long id) {
        Optional<Livro> obj = repository.findById(id);
        if(obj.isPresent()) {
            Livro livro = obj.get();
            return ResponseEntity.ok().body(new LivroDetalhesResponse(livro));
        }

        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cadastra um livro na base de dados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 400, message = "bad request", response = ErrorForm.class)
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid LivroForm livroForm) {
        Optional<Livro> livroObj = livroForm.converter(autorRepository, categoriaRepository);
        if(livroObj.isPresent()) {
            repository.save(livroObj.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
