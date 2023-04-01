package com.example.takehome.configuration;

import com.example.takehome.converter.ContinentDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionServiceConfig {

    @Bean
    ConversionService countryConversionService() {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converterSet = new HashSet<>();
        converterSet.add(new ContinentDTOConverter());
        factoryBean.setConverters(converterSet);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
