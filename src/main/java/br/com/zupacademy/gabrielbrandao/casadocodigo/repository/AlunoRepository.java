package br.com.zupacademy.gabrielbrandao.casadocodigo.repository;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
