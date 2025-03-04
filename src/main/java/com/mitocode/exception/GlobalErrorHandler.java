package com.mitocode.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice//lo q se dice es que esta anotacion sirve como un interceptador para detectar las excep q se define en el excephandeler
public class GlobalErrorHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(exception = Exception.class)//esta se ejecuta cuando no haya caido en las otras reglas
	public ResponseEntity<CustomErrorResponse> handlerAllExcpetion(Exception ex, WebRequest request){
		
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(errorResponse, HttpStatus.PRECONDITION_FAILED);
		
	}
	@ExceptionHandler(exception = ModelNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handlerModelNotFoundExcpetion(ModelNotFoundException ex, WebRequest request){
		
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override//se lanza cuando no cumple con los constraint en los dto
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		/*String mesage = "";
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			mesage += error.getField()+" : "+error.getDefaultMessage()+ " , ";
		}*/
		
		//lo mismo de arriba
		String mesage = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getField()+" : "+ e.getDefaultMessage() ).collect(Collectors.joining(","));
		
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), mesage, request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
