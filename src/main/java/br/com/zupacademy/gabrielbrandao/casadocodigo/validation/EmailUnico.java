package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidadorEmailUnico.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface EmailUnico {

    public String message() default "Já existe um autor com esse e-mail!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
