package com.cts.eaution.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author aadi 
 * Global exception handler
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	 private static final Logger logger = LogManager.getLogger(CustomExceptionHandler.class);

	/**
	 * Method to handle Generic exception handle and build error response
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity of error
	 */
	@ExceptionHandler(SecurityException.class)
	public final ResponseEntity<Object> handleSecurityExceptions(SecurityException ex, WebRequest request) {
		List<String> details = null;
		String exceptionDetails = null;
		String msg=	ex.getMessage();
		String description=	ex.getDescrpition();
		
		
			details = new ArrayList<>();
			details.add(description);
			
		details.add(exceptionDetails);
		logger.error("Product Mgt : Inside global exception handler",ex);

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				msg, null, ex.getLocalizedMessage(), details);
		return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/**
	 *For custom validations
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), ExceptionCodes.VALIDATION,
				null, ex.getLocalizedMessage(), details);
		return new ResponseEntity<>(errorResponse, status);
	}
}
