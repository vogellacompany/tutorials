package com.vogella.unittest.email;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailValidatorTest {
	// TODO Write test for EmailValidator
	// The names of the methods should give you a pointer what to test for

	@Test
	void ensureThatEmailValidatorReturnsTrueForValidEmail() {
		assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
	}

	@Test
	void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
		assertTrue(EmailValidator.isValidEmail("lars.vogel@analytics.gmail.com"));
	}

	@Test
	void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail("lars.vogel@gmail"));
	}

	@Test
	void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail("lars..vogel@gmail..com"));
	}

	@Test
	void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail("1@gmail..com"));
	}

	@Test
	void emailValidator_EmptyString_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail(""));
	}

	@Test
	void emailValidator_NullEmail_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail(null));
	}

}
