package com.ivoronline.springboot_validation_custom.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeConstraintImpl.class)
public @interface AgeConstraint {
  String                     message() default "Must be between 18 and 100";
  Class<?>[]                 groups () default {};
  Class<? extends Payload>[] payload() default {};
}
