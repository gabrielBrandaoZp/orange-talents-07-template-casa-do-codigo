package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;


import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidadorCategoriaUnica implements ConstraintValidator<CategoriaUnica, String> {

    private CategoriaRepository categoriaRepository;

    public ValidadorCategoriaUnica(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Categoria> categoriaObj = categoriaRepository.findByNome(nome);
        return nome != null && !categoriaObj.isPresent();
    }
}
