package br.com.zupacademy.gabrielbrandao.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidadorCpfCnpj.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface CpfCnpj {

    public String message() default "{br.com.zupacademy.gabrielbrandao.casadocodigo.beanvalidation.cpfcnpj}";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
