package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.PaisRepository;
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
public class EstadoController {

    private EstadoRepository repository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository repository, PaisRepository paisRepository) {
        this.repository = repository;
        this.paisRepository = paisRepository;
    }

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
