package com.example.passwordvalidation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.passwordvalidation.dto.PasswordLengthRule;
import com.example.passwordvalidation.dto.PasswordNotNullRule;
import com.example.passwordvalidation.dto.PasswordOneLowerCaseRule;
import com.example.passwordvalidation.dto.PasswordOneNumberRule;
import com.example.passwordvalidation.dto.PasswordOneUpperCaseRule;
import com.example.passwordvalidation.dto.PasswordValidationRule;
import com.example.passwordvalidation.dto.PasswordValidationRuleResponse;
import com.example.passwordvalidation.exception.PasswordPolicyException;

@Service
public class PasswordValidationService {
	
	List<PasswordValidationRule> ruleList;
	
	public boolean isValidPassword(String password) throws PasswordPolicyException {
		ruleList = new ArrayList<>();
		ruleList.add(new PasswordLengthRule());
		ruleList.add(new PasswordNotNullRule());
		ruleList.add(new PasswordOneUpperCaseRule());
		ruleList.add(new PasswordOneLowerCaseRule());
		ruleList.add(new PasswordOneNumberRule());
		
		List<PasswordValidationRuleResponse> ruleResponse = ruleList.stream().map(obj -> obj.isValid(password)).collect(Collectors.toList());
		List<String> errorList = ruleResponse.stream().filter(obj -> !obj.isValid())
		.map(PasswordValidationRuleResponse::getErrorMessage).collect(Collectors.toList());
		
		if(CollectionUtils.isEmpty(errorList)) {
			return true;
		}else {
			throw new PasswordPolicyException(400, errorList.toString());
		}
	}

}
