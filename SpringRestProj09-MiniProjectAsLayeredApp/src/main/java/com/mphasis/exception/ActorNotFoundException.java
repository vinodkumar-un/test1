package com.mphasis.exception;

public class ActorNotFoundException extends RuntimeException {
	
	public ActorNotFoundException() {
		super();
	}
	
	public ActorNotFoundException(String msg) {
		super(msg);
	}

}
