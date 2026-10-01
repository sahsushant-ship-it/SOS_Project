package com.sos.responce;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponce<T> {
	
	private Boolean success;
	
	private String message;
	
	private T data;
	
	private HttpStatus httpStatus;

}
