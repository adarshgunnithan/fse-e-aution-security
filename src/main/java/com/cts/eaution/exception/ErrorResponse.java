package com.cts.eaution.exception;

import java.util.List;

/**
 * @author aadi
 *VO to give error response
 */
public class ErrorResponse {
	
/**
 * http response code
 */
private String httpResponseCode;
/**
 * custom status code
 */
private String status;

/**
 * unique trace id for transaction
 */
private String traceID; 

/**
 * exception message
 */
private String message;
/**
 * details of exception,incase of nested
 */
private List<String> details;


public ErrorResponse(String httpResponseCode, String status, String traceID, String message, List<String> details) {
	super();
	this.httpResponseCode = httpResponseCode;
	this.status = status;
	this.traceID = traceID;
	this.message = message;
	this.details = details;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getTraceID() {
	return traceID;
}
public void setTraceID(String traceID) {
	this.traceID = traceID;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<String> getDetails() {
	return details;
}
public void setDetails(List<String> details) {
	this.details = details;
}
public String getHttpResponseCode() {
	return httpResponseCode;
}
public void setHttpResponseCode(String httpResponseCode) {
	this.httpResponseCode = httpResponseCode;
}






}
