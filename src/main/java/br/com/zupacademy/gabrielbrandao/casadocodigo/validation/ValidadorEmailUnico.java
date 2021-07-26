package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;


import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AutorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidadorEmailUnico implements ConstraintValidator<EmailUnico, String> {

    private AutorRepository autorRepository;

    public ValidadorEmailUnico(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Autor> autorObj = autorRepository.findByEmail(email);
        return email != null && !autorObj.isPresent();
    }
}
