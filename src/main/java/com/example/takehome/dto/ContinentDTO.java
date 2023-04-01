package com.example.takehome.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContinentDTO {

    List<String> countries;

    String name;

    List<String> otherCountries;
}
