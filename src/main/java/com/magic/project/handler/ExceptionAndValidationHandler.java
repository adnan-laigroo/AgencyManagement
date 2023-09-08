package com.magic.project.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionAndValidationHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult br = ex.getBindingResult();
		List<ObjectError> errors = br.getAllErrors();
		List<String> errorMessages = new ArrayList<>();
		for (ObjectError error : errors) {
			if (error instanceof FieldError) {
				FieldError fieldError = (FieldError) error;
				String errorMessage = fieldError.getDefaultMessage();
				errorMessages.add(errorMessage);
			}
		}
		if (errorMessages.isEmpty()) {
			errorMessages.add("Invalid request payload");
		}
		ResponseError response = new ResponseError("Validation Failed", errorMessages);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}



	@ExceptionHandler(AgencyNotFoundException.class)
	public ResponseEntity<Object> handleDoctorNotFoundException(AgencyNotFoundException ex) {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.add(ex.getMessage());
		ResponseError response = new ResponseError("Doctor Not Found", errorMessages);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(WorkerNotFoundException.class)
	public ResponseEntity<Object> handleReceptionistNotFoundException(WorkerNotFoundException ex) {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.add(ex.getMessage());
		ResponseError response = new ResponseError("Receptionist Not Found", errorMessages);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.add(ex.getMessage());
		ResponseError response = new ResponseError("User Not Found", errorMessages);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}


	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex) {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.add(ex.getMessage());
		ResponseError response = new ResponseError("Username Not Found Exception", errorMessages);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}


}
