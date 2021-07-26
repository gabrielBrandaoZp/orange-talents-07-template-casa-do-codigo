package br.com.zupacademy.gabrielbrandao.casadocodigo.repository;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
