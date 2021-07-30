package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response.LivroDetalhesResponse;
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
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesResponse> livroPorId(@PathVariable Long id) {
        Optional<Livro> obj = repository.findById(id);
        if(obj.isPresent()) {
            Livro livro = obj.get();
            return ResponseEntity.ok().body(new LivroDetalhesResponse(livro));
        }

        return ResponseEntity.notFound().build();
    }

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
