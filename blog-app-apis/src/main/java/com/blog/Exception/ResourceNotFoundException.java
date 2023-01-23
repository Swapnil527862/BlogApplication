package com.blog.Exception;

public class ResourceNotFoundException extends RuntimeException {
	String resourcename;
	String fieldname;
	long feildvalue;
	public ResourceNotFoundException(String resourcename, String fieldname, long feildvalue) {
		super();
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.feildvalue = feildvalue;
	}
	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super("Not Found Resource", cause, enableSuppression, writableStackTrace);
		
	}
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message) {
		super("Not Found");
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



}
