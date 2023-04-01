package com.example.takehome.controller;

import com.example.takehome.data.CountriesData;
import com.example.takehome.dto.ContinentDTO;
import com.example.takehome.dto.ContinentListDTO;
import com.example.takehome.facade.CountryFacade;
import graphql.GraphQLException;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/countries")
public class CountriesController {

    @Autowired
    CountryFacade countryFacade;

    @GetMapping("/sameContinent")
    public ResponseEntity<?> getSameContinentCountries(@RequestParam List<String> countries){
        List<ContinentDTO> continentDTOs = countryFacade.getSameContinentCountries(countries);
        ContinentListDTO listDTO = new ContinentListDTO();
        listDTO.setContinent(continentDTOs);
        return ResponseEntity.ok(listDTO);
    }

}
