package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.AlunoForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Aluno;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AlunoForm alunoForm) {
        Aluno aluno = alunoForm.converter();
        repository.save(aluno);
        return ResponseEntity.ok().build();
    }

}
