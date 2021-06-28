package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/country", method=RequestMethod.GET)
	public Country getCountryIndia() {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) cxt.getBean("in",Country.class);
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) cxt.getBean("countryList");
		return countryList;
	}
	
	@GetMapping(value="/countries/{code}")
	public Country getCountry(@PathVariable("code") String countrycode) throws CountryNotFoundException{
		return countryService.getCountry(countrycode);
	}
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START");
		LOGGER.debug("Country{}" + country);
		return country;
	}
}
