package br.com.casaDoCodigo.Validation;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueFieldValidator implements ConstraintValidator<UniqueFieldConstraint, Object> {

	private String column;
	private Class<?> clazz;
	private final EntityManager entityManager;

	public UniqueFieldValidator(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public void initialize(UniqueFieldConstraint constraintAnnotation) {
		this.column = constraintAnnotation.columnName();
		this.clazz = constraintAnnotation.model();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		var query = entityManager
				.createQuery("Select " + column + " FROM " + clazz.getSimpleName() + " WHERE " + column + " = :value");
		query.setParameter("value", value);

		if (query.getResultList().size() > 0) {
			return false;
		}
		return true;

	}

}
