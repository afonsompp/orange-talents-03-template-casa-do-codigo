package br.com.casaDoCodigo.Validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.casaDoCodigo.repository.AuthorRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailConstraint, String> {

	private final AuthorRepository authorRepository;

	public UniqueEmailValidator(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		var email = authorRepository.findByEmail(value);

		if (email.isPresent()) {
			return false;
		}
		return true;
	}

}
