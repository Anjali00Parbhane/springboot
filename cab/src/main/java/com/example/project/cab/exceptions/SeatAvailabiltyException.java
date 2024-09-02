package com.example.project.cab.exceptions;

public class SeatAvailabiltyException extends RuntimeException{

	public SeatAvailabiltyException() {
		
	}
	public SeatAvailabiltyException(String msg) {
		super(msg);
	}
}
