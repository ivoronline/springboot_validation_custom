package com.ivoronline.springboot_validation_custom.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = AgeConstraintImpl.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeConstraint {
    String                     message() default "Must be between 18 and 100";
    Class<?>[]                 groups () default {};
    Class<? extends Payload>[] payload() default {};
}
