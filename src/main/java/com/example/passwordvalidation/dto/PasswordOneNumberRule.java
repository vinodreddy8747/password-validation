package com.example.passwordvalidation.dto;

import java.util.function.IntPredicate;

import org.springframework.stereotype.Service;

@Service
public class PasswordOneNumberRule extends PasswordValidationRule {

	public PasswordValidationRuleResponse isValid(String password) {
		boolean isValid = containsNumber(password);
		return new PasswordValidationRuleResponse(isValid, !isValid ? PASSWORD_ONE_DIGIT_MSG : STR_EMPTY);
	}

	private boolean containsNumber(String value) {
		return contains(value, Character::isDigit);
	}

	private boolean contains(String value, IntPredicate predicate) {
		return value.chars().anyMatch(predicate);
	}

}
