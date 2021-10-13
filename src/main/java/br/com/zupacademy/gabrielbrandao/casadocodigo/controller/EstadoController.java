package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.exception.ErrorForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.EstadoRepository;
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
import java.util.Optional;

@RestController
@RequestMapping("/estados")
@Api(tags = "Estado Controller")
public class EstadoController {

    private EstadoRepository repository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository repository, PaisRepository paisRepository) {
        this.repository = repository;
        this.paisRepository = paisRepository;
    }

    @ApiOperation(value = "Cadastra de um estado na base de dados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 400, message = "bad request", response = ErrorForm.class),
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid EstadoForm estadoForm) {
        Optional<Estado> estadoObj = estadoForm.converter(paisRepository);
        if(estadoObj.isPresent()) {
            repository.save(estadoObj.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

}
