package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response.LivroInfoResponse;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository repository;
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository repository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public ResponseEntity<List<LivroInfoResponse>> livros() {
        List<Livro> livros = repository.findAll();
        List<LivroInfoResponse> livrosInfo = LivroInfoResponse.converter(livros);
        return ResponseEntity.ok().body(livrosInfo);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid LivroForm livroForm) {
        Livro livro = livroForm.converter(autorRepository, categoriaRepository);
        repository.save(livro);
        return ResponseEntity.ok().build();
    }
}
