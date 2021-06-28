package com.cognizant.springlearn;

import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("START");
		
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		displayCountry();
		displayCountries();
		
		LOGGER.info("END");
	}
	
	public static void displayDate() {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = cxt.getBean("dateFormat", SimpleDateFormat.class);
		Date date = new Date();
		
		String tDate = format.format(date);
		LOGGER.debug("Today is:" + tDate);
	
	}
	
	public static void displayCountry() {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) cxt.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		//calling constructor twice with scope as default(singleton) and then prototype scope 
		
		Country anotherCountry = cxt.getBean("country", Country.class); 
		//case 1 : singleton scope - logger prints inside constructor only once implying constructor is invoked only once
		//case 2 : prototype scope - logger prints inside constructor twice implying constructor is invoked twice
	}
	
	public static void displayCountries() {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countryList = (ArrayList<Country>) cxt.getBean("countryList");
		LOGGER.debug("Country List: {}", countryList.toString());
	}

}
