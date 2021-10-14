package cundi.edu.co.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflicException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflicException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
