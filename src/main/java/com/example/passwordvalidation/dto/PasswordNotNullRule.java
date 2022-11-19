package com.example.passwordvalidation.dto;

import org.springframework.stereotype.Service;

@Service
public class PasswordNotNullRule extends PasswordValidationRule{
	
	public PasswordValidationRuleResponse isValid(String password) {
		boolean isValid = (null != password && password.length() > 0);
		return new PasswordValidationRuleResponse(isValid, !isValid ? PASSWORD_NOT_NULL_MSG : STR_EMPTY);
	}
}
