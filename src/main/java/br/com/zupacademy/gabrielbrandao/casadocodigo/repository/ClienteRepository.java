package br.com.zupacademy.gabrielbrandao.casadocodigo.repository;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
