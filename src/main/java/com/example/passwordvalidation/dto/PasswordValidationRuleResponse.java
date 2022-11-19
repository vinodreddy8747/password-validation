package com.example.passwordvalidation.dto;

import java.util.Objects;

import lombok.Data;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class PasswordValidationRuleResponse {
	public PasswordValidationRuleResponse(boolean isValid2, String msg) {
		this.isValid = isValid2;
		this.errorMessage = msg;
	}
	public boolean isValid;
	public String errorMessage;
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(errorMessage, isValid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasswordValidationRuleResponse other = (PasswordValidationRuleResponse) obj;
		return Objects.equals(errorMessage, other.errorMessage) && isValid == other.isValid;
	}
	@Override
	public String toString() {
		return "PasswordValidationRuleResponse [isValid=" + isValid + ", errorMessage=" + errorMessage + "]";
	}
	
}
