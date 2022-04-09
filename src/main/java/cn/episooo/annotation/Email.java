package cn.episooo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailConstraintValidator.class)
public @interface Email {
    String message() default "Email address is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
