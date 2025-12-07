package com.piseth.java.school.roomownerservice.exception;

import com.piseth.java.school.roomownerservice.domain.enumeration.Outcome;

public class ValidationException extends ApplicationException{

	public ValidationException(String message) {
		super(Outcome.VALIDATION, message);
	}

}
