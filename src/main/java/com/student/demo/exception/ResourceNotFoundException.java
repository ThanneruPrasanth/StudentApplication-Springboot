package com.student.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceNmae;
	private String fieldNmae;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resourceNmae, String fieldNmae, Object fieldValue) {
		super(String .format("%s not found with %s : '%s'", resourceNmae, fieldNmae,fieldValue));
		this.resourceNmae = resourceNmae;
		this.fieldNmae = fieldNmae;
		this.fieldValue = fieldValue;
	}

	public String getResourceNmae() {
		return resourceNmae;
	}

	public String getFieldNmae() {
		return fieldNmae;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	
}
