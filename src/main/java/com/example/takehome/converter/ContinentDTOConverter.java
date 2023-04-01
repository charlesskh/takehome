package com.example.takehome.converter;

import com.example.takehome.data.ContinentData;
import com.example.takehome.data.CountryData;
import com.example.takehome.dto.ContinentDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContinentDTOConverter implements Converter<ContinentData, ContinentDTO> {

    @Override
    public ContinentDTO convert(ContinentData source) {
        ContinentDTO dto = new ContinentDTO();
        dto.setCountries(new ArrayList<>());
        List<String> countries = new ArrayList<>();
        for(CountryData countryData : source.getCountries()){
            countries.add(countryData.getCode());
        }
        dto.setOtherCountries(countries);
        dto.setName(source.getName());
        return dto;
    }
}
