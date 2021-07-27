package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.EstadoRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidadorEstadoNomePaisUnico implements ConstraintValidator<EstadoNomePaisUnico, EstadoForm> {

    private EstadoRepository estadoRepository;

    public ValidadorEstadoNomePaisUnico(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean isValid(EstadoForm value, ConstraintValidatorContext context) {
        Optional<Estado> objEstado = estadoRepository.findByNomeAndPaisId(value.getNome(), value.getPaisId());
        return !objEstado.isPresent();
    }
}
