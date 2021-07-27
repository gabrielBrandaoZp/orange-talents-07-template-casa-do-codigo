package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.EstadoNomePaisUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@EstadoNomePaisUnico
public class EstadoForm {

    @NotBlank
    private String nome;

    @NotNull
    private Long paisId;

    public EstadoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado converter(PaisRepository paisRepository) {
        Optional<Pais> objPais = paisRepository.findById(paisId);
        @NotBlank Pais pais = objPais.get();
        Estado estado = new Estado(nome, pais);
        pais.adicionaEstado(estado);
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
