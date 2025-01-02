package com.priyansh.fdAPI.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String resource;
	private Integer id;
	
	public ResourceNotFoundException(String resourceName, String resource, Integer id) {
		super(String.format("%s not found in %s with id: %s",resourceName,resource,id));
		this.resourceName = resourceName;
		this.resource = resource;
		this.id = id;
	}
	
	

}
