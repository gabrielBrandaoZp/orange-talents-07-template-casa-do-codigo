package br.com.zupacademy.gabrielbrandao.casadocodigo.repository;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
