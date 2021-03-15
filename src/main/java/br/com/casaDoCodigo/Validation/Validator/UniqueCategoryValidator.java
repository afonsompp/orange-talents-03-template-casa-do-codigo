package br.com.casaDoCodigo.Validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.casaDoCodigo.repository.CategoryRepository;

public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategoryConstraint, String> {

	private final CategoryRepository categoryRepository;

	public UniqueCategoryValidator(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		var category = categoryRepository.findByName(value);
		if (category.isPresent()) {
			return false;
		}
		return true;
	}

}
