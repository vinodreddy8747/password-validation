package com.example.passwordvalidation.dto;

import java.util.function.IntPredicate;

import org.springframework.stereotype.Service;

@Service
public class PasswordOneLowerCaseRule extends PasswordValidationRule {

	public PasswordValidationRuleResponse isValid(String password) {
		boolean isValid = containsLowerCase(password);
		return new PasswordValidationRuleResponse(isValid, !isValid ? PASSWORD_ONE_LOWERCASE_MSG : STR_EMPTY);
	}

	private boolean containsLowerCase(String value) {
		return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
	}

	private boolean contains(String value, IntPredicate predicate) {
		return value.chars().anyMatch(predicate);
	}
}
