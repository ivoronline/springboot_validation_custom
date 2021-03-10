package com.ivoronline.springboot_validation_custom.controllers;

import com.ivoronline.springboot_validation_custom.validators.AgeConstraint;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@Validated
public class MyController {

  //==================================================================
  // HELLO
  //==================================================================
  @ResponseBody
  @RequestMapping("/Hello")
  public String hello(@AgeConstraint @RequestParam Integer age) {
    return "John is " + age + " years old";
  }

  //==================================================================
  // HANDLE EXCEPTIONS (it only catches first exception)
  //==================================================================
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public Map<String, String> handleExceptions(ConstraintViolationException exception) {

    //CREATE MAP FOR STORING ERRORS
    Map<String, String> errors = new HashMap<>();

    //ITERATE THROUGH ERRORS
    Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
    for(ConstraintViolation<?> violation : violations) {

      //GET PROPERTY NAME
      String propertyName = null;
      for (Path.Node node : violation.getPropertyPath()) { propertyName = node.getName(); }

      //GET OTHER ERROR COMPONENTS
      String  message      =           violation.getMessage();
      Integer invalidValue = (Integer) violation.getInvalidValue();

      //STORE ERROR
      errors.put(propertyName, message + " (" + invalidValue + ")");

    }

    //RETURN MESSAGE
    return errors;
  }

}
