package com.countries.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.countries.app.pojos.Countries;
import com.countries.app.services.CountriesService;

@RestController
@RequestMapping(path="/countries")
public class CountriesController {
	
	@Autowired
	private CountriesService countriesService;
	
	 @GetMapping(path="/all", produces = "application/json")
	    public ResponseEntity<List<Countries>> getCountries() 
	    {
		    List<Countries> list = new ArrayList<>();
		    list=countriesService.getAllCountries();
		    HttpHeaders header = new HttpHeaders();
		    header.add("desc", "Full Countries List");
		    //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    return ResponseEntity.status(HttpStatus.OK).headers(header).body(list);
	    }
	 
	 	@GetMapping(path="/name/{name}", produces = "application/json")
	    public List<Countries> getCountryByName(@PathVariable String name) 
	    {
	        return countriesService.getCountryByName(name);
	    }	 
	 
		 
		@GetMapping(path="/currency/{currency}", produces = "application/json")
	    public List<Countries> getCountryByCurrency(@PathVariable String currency) 
	    {
	        return countriesService.getCountryByCurrency(currency);
	    }
		
		
		@GetMapping(path="/language/{language}", produces = "application/json")
	    public List<Countries> getCountryByLanguage(@PathVariable String language) 
	    {
	        return countriesService.getCountryByLangauge(language);
	    }
		
		@GetMapping(path="/capital/{capital}", produces = "application/json")
	    public List<Countries> getCountryByCapital(@PathVariable String capital) 
	    {
	        return countriesService.getCountryByCapital(capital);
	    }
		
		@GetMapping(path="/region/{region}", produces = "application/json")
	    public List<Countries> getCountriesByRegion(@PathVariable String region) 
	    {
	        return countriesService.getCountriesByRegion(region);
	    }
		
		@GetMapping(path="/subregion/{subregion}", produces = "application/json")
	    public List<Countries> getCountriesBySubRegion(@PathVariable String subregion) 
	    {
	        return countriesService.getCountriesBySubRegion(subregion);
	    }

}
