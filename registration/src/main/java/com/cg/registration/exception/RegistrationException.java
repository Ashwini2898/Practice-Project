package com.cg.registration.exception;

public class RegistrationException extends Exception{

	private String message;

	public RegistrationException()
	{
		
	}
	
	public RegistrationException(String message,Exception e)
	{
		super(message);
		this.message=message;
	}

	@Override
	public String toString() {
		return "RegistrationException [message=" + message + "]";
	}
}
