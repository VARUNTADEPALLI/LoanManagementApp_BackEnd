package com.varun.Exceptions;

public class UserDoesnotExistException extends RuntimeException{
	
		private String message;
		 
	    public UserDoesnotExistException() {}
	 
	    public UserDoesnotExistException(String msg)
	    {
	        super(msg);
	        this.message = msg;
	    }

	

}
