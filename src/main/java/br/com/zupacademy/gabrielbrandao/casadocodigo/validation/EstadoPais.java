package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EstadoPaisValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
public @interface EstadoPais {
    String message() default "Constraint Violation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
