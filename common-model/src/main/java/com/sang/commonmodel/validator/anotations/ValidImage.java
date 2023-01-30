package com.sang.commonmodel.validator.anotations;

import com.sang.commonmodel.validator.ImageFileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ImageFileValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidImage {
    String message() default "File is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
