package com.example.takehome.data;

import lombok.Data;

import java.util.List;

@Data
public class ContinentData {

    String code;

    List<CountryData> countries;

    String name;
}
