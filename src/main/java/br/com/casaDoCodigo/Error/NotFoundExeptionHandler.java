package br.com.casaDoCodigo.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class NotFoundExeptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ObjectError handler(ResponseStatusException e) {
		var exception = new ObjectError(getExceptionMessage(e), e.getStatus().value());
		return exception;
	}

	private String getExceptionMessage(ResponseStatusException e) {
		var start =  e.getMessage().indexOf("\"") +1;
		var end = e.getMessage().lastIndexOf("\"");
		var message = e.getMessage().substring(start, end);
		return message;
	}
}
