package com.countries.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.countries.app.mappers.CountriesMapper;
import com.countries.app.pojos.Countries;
import com.countries.app.pojos.CountriesExample;

@Service
public class CountriesService {
	
	
	private CountriesMapper countriesMapper;

	public CountriesService(CountriesMapper countriesMapper) {
		this.countriesMapper = countriesMapper;

	}

	// Select all the countries
	public List<Countries> getAllCountries() {
		CountriesExample countriesExample = new CountriesExample();
		List<Countries> countriesList = countriesMapper.selectByExample(countriesExample);
		return countriesList;
	}
	
	// Get Any Country by Name
	public List<Countries> getCountryByName(String name) {
		CountriesExample countriesExample = new CountriesExample();
		CountriesExample.Criteria criteriaCountries = countriesExample.createCriteria();
		criteriaCountries.andNameLike(name + "%");
		List<Countries> countriesList = countriesMapper.selectByExample(countriesExample);
		return countriesList;
	}
	
	public List<Countries> getCountryByCurrency(String currency) {
		CountriesExample countriesExample = new CountriesExample();
		CountriesExample.Criteria criteriaCountries = countriesExample.createCriteria();
		criteriaCountries.andCurrencies0nameLike("%" + currency + "%");
		List<Countries> countriesList = countriesMapper.selectByExample(countriesExample);
		return countriesList;
	}
	
	public List<Countries> getCountryByLangauge(String language) {
		CountriesExample countriesExample = new CountriesExample();
		CountriesExample.Criteria criteriaCountries = countriesExample.createCriteria();
		criteriaCountries.andLanguages0nameLike("%" + language + "%");
		List<Countries> countriesList = countriesMapper.selectByExample(countriesExample);
		return countriesList;
	}
	
	public List<Countries> getCountryByCapital(String capital) {
		CountriesExample countriesExample = new CountriesExample();
		CountriesExample.Criteria criteriaCountries = countriesExample.createCriteria();
		criteriaCountries.andCapitalEqualTo(capital);
		List<Countries> countriesList = countriesMapper.selectByExample(countriesExample);
		return countriesList;
	}
	
	
	public List<Countries> getCountriesByRegion(String region) {
		CountriesExample countriesExample = new CountriesExample();
		CountriesExample.Criteria criteriaCountries = countriesExample.createCriteria();
		criteriaCountries.andRegionEqualTo(region);
		List<Countries> countriesList = countriesMapper.selectByExample(countriesExample);
		return countriesList;
	}
	
	public List<Countries> getCountriesBySubRegion(String subregion) {
		CountriesExample countriesExample = new CountriesExample();
		CountriesExample.Criteria criteriaCountries = countriesExample.createCriteria();
		criteriaCountries.andSubregionEqualTo(subregion);
		List<Countries> countriesList = countriesMapper.selectByExample(countriesExample);
		return countriesList;
	}

}
