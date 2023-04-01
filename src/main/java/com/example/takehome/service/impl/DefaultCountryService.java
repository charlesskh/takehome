package com.example.takehome.service.impl;

import com.example.takehome.client.CountryClient;
import com.example.takehome.data.ContinentData;
import com.example.takehome.data.CountriesData;
import com.example.takehome.data.CountryData;
import com.example.takehome.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultCountryService implements CountryService {

    @Autowired
    CountryClient countryClient;

    public Map<String, ContinentData> getContinentForCountries(List<String> countries){
        CountriesData result = countryClient.getCountriesByCode(countries);
        Map<String, ContinentData> map = new HashMap<>();
        for(CountryData data : result.getCountries()){
            map.put(data.getCode(), data.getContinent());
        }
        return map;
    }
}
