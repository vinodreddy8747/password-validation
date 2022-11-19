package com.example.passwordvalidation.dto;

import org.springframework.stereotype.Service;

@Service
public class PasswordLengthRule extends PasswordValidationRule {

	@Override
	public PasswordValidationRuleResponse isValid(String password) {
		boolean isValid = password.length() > 8;
		String msg = (!isValid) ? PASSWORD_LENGTH_GREATER8_MSG : STR_EMPTY;
		return new PasswordValidationRuleResponse(isValid, msg);
	}

}
