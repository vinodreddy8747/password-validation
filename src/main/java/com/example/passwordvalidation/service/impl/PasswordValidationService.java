package com.example.passwordvalidation.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.passwordvalidation.dto.PasswordValidationRule;
import com.example.passwordvalidation.dto.PasswordValidationRuleResponse;
import com.example.passwordvalidation.exception.PasswordPolicyException;
import com.example.passwordvalidation.utils.AppConstants;

@Service
public class PasswordValidationService {

	public boolean isValidPassword(String password, List<PasswordValidationRule> ruleList)
			throws PasswordPolicyException {
		
		if(StringUtils.isEmpty(password)) {
			throw new PasswordPolicyException(HttpStatus.BAD_REQUEST.value(), AppConstants.PASSWORD_NOT_NULL_MSG);
		}
		
		List<PasswordValidationRuleResponse> ruleResponse = ruleList.parallelStream().map(obj -> obj.isValid(password))
				.collect(Collectors.toList());
		List<String> errorList = ruleResponse.stream().filter(obj -> !obj.isValid())
				.map(PasswordValidationRuleResponse::getErrorMessage).collect(Collectors.toList());

		//Among 4 conditions 2 are success we are returning true
		if (null != errorList && 
			errorList.size() <= 2 && 
			!errorList.contains(AppConstants.PASSWORD_ONE_LOWERCASE_MSG)) {
			return true;
		} else {
			//we are returning all error messages 
			throw new PasswordPolicyException(HttpStatus.BAD_REQUEST.value(), errorList.toString());
		}
	}

}
