package com.ivoronline.springboot_validation_custom.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintImpl implements ConstraintValidator<AgeConstraint, Integer> {

  @Override
  public void initialize(AgeConstraint age) { }

  @Override
  public boolean isValid(Integer age, ConstraintValidatorContext cxt) {
    return 18 < age && age < 100;
  }

}
