package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.exception.ErrorForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AutorRepository;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
@Api(tags = "Autor Controller")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Cadastra um autor na base de dados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 400, message = "bad request", response = ErrorForm.class),
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.converter();
        repository.save(autor);
        return ResponseEntity.ok().build();
    }

}
