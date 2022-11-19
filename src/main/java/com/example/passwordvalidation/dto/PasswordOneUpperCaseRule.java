package com.example.passwordvalidation.dto;

import java.util.function.IntPredicate;

import org.springframework.stereotype.Service;

@Service
public class PasswordOneUpperCaseRule extends PasswordValidationRule {

	public PasswordValidationRuleResponse isValid(String password) {
		boolean isValid = containsUpperCase(password);
		return new PasswordValidationRuleResponse(isValid, !isValid ? PASSWORD_ONE_UPPERCASE_MSG : STR_EMPTY);
	}

	private boolean containsUpperCase(String value) {
		return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
	}

	private boolean contains(String value, IntPredicate predicate) {
		return value.chars().anyMatch(predicate);
	}
}
