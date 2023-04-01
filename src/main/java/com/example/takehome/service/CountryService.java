package com.example.takehome.service;

import com.example.takehome.data.ContinentData;

import java.util.List;
import java.util.Map;

public interface CountryService {

    Map<String, ContinentData> getContinentForCountries(List<String> countries);
}
