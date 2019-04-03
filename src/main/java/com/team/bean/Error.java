package com.team.bean;

import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

public class Error {
	private Map<String,Object> maps;

	private List<FieldError> errors;
	
	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}

	public static Map<String,Object> Traversal(List<FieldError> errors,Map<String,Object> maps){
		for(FieldError error:errors) {
			maps.put(error.getField(), error.getDefaultMessage());
		}
		return maps;
	}
}
