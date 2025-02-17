package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;

import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.EstadoNomePaisUnico;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@EstadoNomePaisUnico
public class EstadoForm {

    @ApiModelProperty(position = 1, example = "Paraiba", required = true)
    @NotBlank
    private String nome;

    @ApiModelProperty(position = 2, example = "2", required = true)
    @NotNull
    private Long paisId;

    public EstadoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Optional<Estado> converter(PaisRepository paisRepository) {
        Optional<Pais> objPais = paisRepository.findById(paisId);
        if(objPais.isPresent()) {
            Pais pais = objPais.get();
            Estado estado = new Estado(nome, pais);
            return Optional.of(estado);
        }

        return Optional.empty();
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
