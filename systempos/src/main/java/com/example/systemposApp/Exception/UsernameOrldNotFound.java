package com.example.systemposApp.Exception;

public class UsernameOrldNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668398822129870029L;

	public UsernameOrldNotFound() {
		super("Usuario o Id no encontrado");
	}
	
	public UsernameOrldNotFound(String message) {
		super(message);
	}
}
