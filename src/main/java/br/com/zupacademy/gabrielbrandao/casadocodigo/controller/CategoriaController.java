package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm) {
        Categoria categoria = new Categoria(categoriaForm.getNome());
        repository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
