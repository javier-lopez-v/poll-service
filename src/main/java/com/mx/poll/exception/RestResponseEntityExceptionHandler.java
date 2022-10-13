package com.mx.poll.exception;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mx.poll.model.GenericResponse;
import com.mx.poll.util.UtilData;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private UtilData utilData;

	@ApiResponses(value = { @ApiResponse(responseCode = "404", content = {
			@Content(mediaType = "	application/json", schema = @Schema(implementation = GenericResponse.class)) }) })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ ParseException.class })
	public ResponseEntity<GenericResponse<CustomException>> handleAccessDeniedException(ParseException ex) {

		return new ResponseEntity<>(
				new GenericResponse<>(false, 404, "Error",
						new CustomException(ex.getMessage(), HttpStatus.NOT_FOUND, utilData.objectToJsonString(ex))),
				HttpStatus.NOT_FOUND);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "405", content = {
			@Content(mediaType = "	application/json", schema = @Schema(implementation = GenericResponse.class)) }) })
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		pageNotFoundLogger.warn(ex.getMessage());

		GenericResponse<CustomException> genericResponse = new GenericResponse<>(false, 404, "Error",
				new CustomException("The type of request is not supported " + ex.getMessage(),
						HttpStatus.METHOD_NOT_ALLOWED, utilData.objectToJsonString(ex)));

		return new ResponseEntity<Object>(genericResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}

}
