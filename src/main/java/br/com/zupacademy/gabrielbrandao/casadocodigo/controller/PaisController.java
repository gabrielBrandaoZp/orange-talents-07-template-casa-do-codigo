package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.PaisForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.PaisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
@Api(tags = "Pais Controller")
public class PaisController {

    private PaisRepository repository;

    public PaisController(PaisRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Cadastra um país na base de dados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 400, message = "bad request")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PaisForm paisForm) {
        Pais pais = paisForm.converter();
        repository.save(pais);
        return ResponseEntity.ok().build();
    }
}
