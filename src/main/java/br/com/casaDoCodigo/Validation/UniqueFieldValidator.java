package br.com.casaDoCodigo.Validation;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueFieldValidator implements ConstraintValidator<UniqueFieldConstraint, Object> {

	private String column;
	private String foreignKey;
	private Class<?> clazz;
	private final EntityManager entityManager;

	public UniqueFieldValidator(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public void initialize(UniqueFieldConstraint constraintAnnotation) {
		this.column = constraintAnnotation.columnName();
		this.foreignKey = constraintAnnotation.foreignKeyName();
		this.clazz = constraintAnnotation.model();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query;
		if (foreignKey.isBlank()) {
			query = entityManager.createQuery(
					"Select " + column + " FROM " + clazz.getSimpleName() + " WHERE " + column + " = :value");
		} else {
			query = entityManager.createQuery("Select " + column + " FROM " + clazz.getSimpleName() + " WHERE " + column
					+ " = :value Group by " + foreignKey + " HAVING COUNT(*) >= 1 ");
		}
		query.setParameter("value", value);

		if (query.getResultList().size() > 0) {
			return false;
		}
		return true;

	}

}
