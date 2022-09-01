package com.muktai.execpHandler;

public class ProductNotFoundException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6376854737399635648L;
	String message;

	public ProductNotFoundException(String message) 
	{
		this.message = message;
	}
	
	
}
