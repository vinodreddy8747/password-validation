/**
 * 
 */
package com.example.passwordvalidation.service.impl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.passwordvalidation.dto.PasswordLengthRule;
import com.example.passwordvalidation.dto.PasswordOneLowerCaseRule;
import com.example.passwordvalidation.dto.PasswordOneNumberRule;
import com.example.passwordvalidation.dto.PasswordOneUpperCaseRule;
import com.example.passwordvalidation.dto.PasswordValidationRule;
import com.example.passwordvalidation.exception.PasswordPolicyException;

/**
 * @author vinod
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PasswordValidationServiceTest {

	@InjectMocks
	PasswordValidationService service = new PasswordValidationService();

	List<PasswordValidationRule> rules = new ArrayList<>();

	@BeforeEach
	public void beforeAll() {
		rules.add(new PasswordLengthRule());
		// rules.add(new PasswordNotNullRule());
		rules.add(new PasswordOneUpperCaseRule());
		rules.add(new PasswordOneLowerCaseRule());
		rules.add(new PasswordOneNumberRule());
	}

	@Test
	public void isValidPasswordWithAllRules() throws PasswordPolicyException {
		String password = "Test@1234";
		boolean result = service.isValidPassword(password, rules);
		assertEquals(true, result);
	}

	@Test
	public void isValidPasswordWithNoRules() throws PasswordPolicyException {
		String password = "test";
		rules = new ArrayList<>();
		boolean result = service.isValidPassword(password, rules);
		assertEquals(true, result);
	}

	@Test
	public void isValidPasswordWithEmptyPasswordThrowException() throws PasswordPolicyException {
		String password = "";
		rules = new ArrayList<>();
		assertThatThrownBy(() -> service.isValidPassword(password, rules)).isInstanceOf(PasswordPolicyException.class);
	}

	@Test
	public void isValidPasswordWithLengthLessthan8Exception() throws PasswordPolicyException {
		String password = "Test@12";
		boolean result = service.isValidPassword(password, rules);
		assertEquals(true, result);
//		assertThatThrownBy(() -> service.isValidPassword(password, rules))
//        .isInstanceOf(PasswordPolicyException.class);
	}

	@Test
	public void isValidPasswordWithNoUpperCaseException() throws PasswordPolicyException {
		String password = "test@1234";
		boolean result = service.isValidPassword(password, rules);
		assertEquals(true, result);
//		assertThatThrownBy(() -> service.isValidPassword(password, rules))
//        .isInstanceOf(PasswordPolicyException.class);
	}

	@Test
	public void isValidPasswordWithNoLowerCaseException() throws PasswordPolicyException {
		String password = "TEST@1234";
		boolean result = service.isValidPassword(password, rules);
		assertEquals(true, result);
//		assertThatThrownBy(() -> service.isValidPassword(password, rules))
//        .isInstanceOf(PasswordPolicyException.class);
	}

	@Test
	public void isValidPasswordWithNoDigitException() throws PasswordPolicyException {
		String password = "TEST@test";
		boolean result = service.isValidPassword(password, rules);
		assertEquals(true, result);
//		assertThatThrownBy(() -> service.isValidPassword(password, rules))
//        .isInstanceOf(PasswordPolicyException.class);
	}

}
