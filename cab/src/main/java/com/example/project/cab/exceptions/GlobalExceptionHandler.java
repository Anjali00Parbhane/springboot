package com.example.project.cab.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> myHandler(Exception ex) {
		
		System.out.println(ex.getLocalizedMessage());
		String msg= ex.getMessage();
		Map<String, String> map= new HashMap<>();
		map.put("message: ", msg);
		
		
		return ResponseEntity.ok().body(map);
	}
}
