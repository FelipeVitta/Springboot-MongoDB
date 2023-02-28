package com.felipeleal.workshopmongo.services.exception;

//RuntimeException não exige que trate a excessão
public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
