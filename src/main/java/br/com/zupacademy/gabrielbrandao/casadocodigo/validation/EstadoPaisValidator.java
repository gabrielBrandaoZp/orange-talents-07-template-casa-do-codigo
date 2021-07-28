package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.exception.ErrorForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.ClienteCadastroForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.PaisRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstadoPaisValidator implements ConstraintValidator<EstadoPais, ClienteCadastroForm> {

    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public EstadoPaisValidator(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean isValid(ClienteCadastroForm clientCadForm, ConstraintValidatorContext context) {
        List<ErrorForm> errors = new ArrayList<>();

        Optional<Pais> objPais = paisRepository.findById(clientCadForm.getPaisId());
        if(objPais.isPresent()) {
            Pais pais = objPais.get();

            if(pais.temEstados()) {
                if(clientCadForm.getEstadoId() == null) {
                    errors.add(new ErrorForm("estadoId", "Você deve informar um estado para o país selecionado"));
                } else {
                    Optional<Estado> objEstado = estadoRepository.findByIdAndPaisId(clientCadForm.getEstadoId(), clientCadForm.getPaisId());
                    if(objEstado.isEmpty())
                        errors.add(new ErrorForm("estadoId", "Você deve informar um estado válido para o país selecionado"));
                }
            }
        } else errors.add(new ErrorForm("paisId", "País com o Id informado não encontrado"));

        insereErrosNoContextoDeValidacao(errors, context);

        return errors.isEmpty();
    }

    private void insereErrosNoContextoDeValidacao(List<ErrorForm> erros, ConstraintValidatorContext context) {
        for(ErrorForm e : erros) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getErro())
                    .addPropertyNode(e.getCampo())
                    .addConstraintViolation();
        }
    }
}
