package br.com.casaDoCodigo.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueFieldValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueFieldConstraint {
	String columnName();

	String foreignKeyName() default "";

	Class<?> model();

	String message() default "{UniqueKey.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
