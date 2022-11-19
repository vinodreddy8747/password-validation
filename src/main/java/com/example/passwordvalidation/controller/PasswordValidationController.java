/**
 * 
 */
package com.example.passwordvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.passwordvalidation.exception.PasswordPolicyException;
import com.example.passwordvalidation.service.impl.PasswordValidationService;

import lombok.RequiredArgsConstructor;

/**
 * @author vinod
 *
 */
@RequestMapping("/password-policy")
public class PasswordValidationController {
	
	@Autowired
	private PasswordValidationService passwordValidationService;

	@PostMapping
	public ResponseEntity<?> validatePassword(@RequestParam String secret){
		try {
			passwordValidationService.isValidPassword(secret);
			return new ResponseEntity<String>("Password validated and status is success for all validation rules!", HttpStatus.OK);
		} catch (PasswordPolicyException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
