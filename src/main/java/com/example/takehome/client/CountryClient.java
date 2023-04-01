package com.example.takehome.client;

import com.example.takehome.data.ContinentData;
import com.example.takehome.data.CountriesData;
import com.example.takehome.data.CountryData;

import java.util.List;
import java.util.Map;

public interface CountryClient {

    CountriesData getCountriesByCode(List<String> codes);

    Map<String, List<CountryData>> getCountriesByContinent(List<String> codes);
}
