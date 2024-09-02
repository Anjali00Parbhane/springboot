package com.example.project.cab.exceptions;

public class MaxRoutesExceededException extends RuntimeException{

	public MaxRoutesExceededException() {
		
	}
	public MaxRoutesExceededException(String msg) {
		super(msg);
	}
	
}
