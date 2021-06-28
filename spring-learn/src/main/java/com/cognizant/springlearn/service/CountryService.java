package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;

@Service
public class CountryService {
	
	public Country getCountry(String code) throws CountryNotFoundException {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) cxt.getBean("countryList");
		for(Country c : countryList)
		{
			if(c.getCode().equalsIgnoreCase(code))
			{
				return c;
			}
		}
		throw new CountryNotFoundException();
	
	}

}
