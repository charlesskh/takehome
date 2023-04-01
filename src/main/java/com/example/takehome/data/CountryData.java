package com.example.takehome.data;

import lombok.Data;

@Data
public class CountryData {

    String code;

    String name;

    ContinentData continent;
}
