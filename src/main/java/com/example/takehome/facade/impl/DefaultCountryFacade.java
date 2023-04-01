package com.example.takehome.facade.impl;

import com.example.takehome.data.ContinentData;
import com.example.takehome.dto.ContinentDTO;
import com.example.takehome.facade.CountryFacade;
import com.example.takehome.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultCountryFacade implements CountryFacade {

    @Autowired
    CountryService countryService;

    @Autowired
    ConversionService countryConversionService;

    @Override
    public List<ContinentDTO> getSameContinentCountries(List<String> countries){
        Map<String, ContinentData> map = countryService.getContinentForCountries(countries);
        Map<String, ContinentDTO> res = new HashMap<>();

        for(Map.Entry<String, ContinentData> entry : map.entrySet()){
            ContinentData continentData = entry.getValue();
            String continentCode = continentData.getCode();
            if(res.containsKey(continentCode)){
                res.get(continentCode).getOtherCountries().remove(entry.getKey());
            } else {
                res.put(continentCode, countryConversionService.convert(continentData, ContinentDTO.class));
            }
            res.get(continentCode).getCountries().add(entry.getKey());
        }
        return new ArrayList<>(res.values());
    }
}
