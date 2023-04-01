package com.example.takehome.facade;

import com.example.takehome.dto.ContinentDTO;

import java.util.List;

public interface CountryFacade {
    List<ContinentDTO> getSameContinentCountries(List<String> countries);

}
