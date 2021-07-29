package com.vogella.unittest.email;

import java.util.regex.Pattern;

public class EmailValidator {

	/**
	 * Email validation pattern.
	 */
	public static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
			+ "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");

	private boolean mIsValid = false;

	public boolean isValid() {
		return mIsValid;
	}

	/**
	 * Validates if the given input is a valid email address.
	 *
	 * @param emailPattern The {@link Pattern} used to validate the given email.
	 * @param email        The email to validate.
	 * @return {@code true} if the input is a valid email. {@code false} otherwise.
	 */
	public static boolean isValidEmail(CharSequence email) {
		return email != null && EMAIL_PATTERN.matcher(email).matches();
	}

}
