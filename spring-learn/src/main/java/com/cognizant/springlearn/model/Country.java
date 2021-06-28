package com.cognizant.springlearn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearn.SpringLearnApplication;

public class Country {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	private String code;
	private String name;
	
	public Country() {
		
		super();
		LOGGER.info("Inside Country Constructor");
	}

	public String getCode() {
		LOGGER.info("Inside getter method of code for " + code);
		return code;
	}

	public void setCode(String code) {
		LOGGER.info("Inside setter method of code for " + code);
		this.code = code;
	}

	public String getName() {
		LOGGER.info("Inside getter method of name for " + name);
		return name;
	}

	public void setName(String name) {
		LOGGER.info("Inside setter method of name for " + name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	
	

}
