package com.cts.eaution.exception;

/**
 * @author aadi
 *
 */
public class SecurityException extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1365814129108898219L;

	/**
	 * exception message
	 */
	private String message;

	/**
	 * exception details
	 */
	private String descrpition;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescrpition() {
		return descrpition;
	}

	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}

	
	public SecurityException(String message, String descrpition) {
		super();
		this.message = message;
		this.descrpition = descrpition;
	}
	
	
}
