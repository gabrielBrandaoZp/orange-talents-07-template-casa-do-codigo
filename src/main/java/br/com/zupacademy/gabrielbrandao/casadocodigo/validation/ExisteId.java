package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidadorExisteId.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ExisteId {

    public String message() default "{br.com.zupacademy.gabrielbrandao.casadocodigo.beanvalidation.existeid}";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};

    String fieldName();

    Class<?> domainClass();
}

