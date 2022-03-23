package com.example.systemposApp.Exception;

public class CostumeFieldValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4995433707591853255L;
	
	private String fieldName;
	
	public CostumeFieldValidationException(String message, String fieldName) {
		super(message);
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
}
