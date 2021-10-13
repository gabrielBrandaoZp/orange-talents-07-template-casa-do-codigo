package br.com.zupacademy.gabrielbrandao.casadocodigo.repository;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
