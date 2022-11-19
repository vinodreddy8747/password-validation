/**
 * 
 */
package com.example.passwordvalidation.dto;

import com.example.passwordvalidation.utils.AppConstants;

/**
 * @author vinod
 *
 */
public abstract class PasswordValidationRule implements AppConstants{
	public abstract PasswordValidationRuleResponse isValid(String password);
}
