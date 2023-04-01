package com.example.takehome.client.impl;

import com.example.takehome.client.CountryClient;
import com.example.takehome.data.CountriesData;
import com.example.takehome.data.CountryData;
import graphql.GraphQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.ClientResponseField;
import org.springframework.graphql.client.GraphQlClientException;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TrevorBladesClient implements CountryClient {

    @Autowired
    HttpGraphQlClient graphQLClient;

    @Override
    public CountriesData getCountriesByCode(List<String> codes) {
        Map<String, Object> param = new HashMap<>();
        param.put("countries", codes.toArray());
        Mono<ClientGraphQlResponse> resMono = graphQLClient.documentName("queryForTrevorBlades")
                .variables(param)
                .execute()
                .timeout((Duration.ofSeconds(5)));
        ClientGraphQlResponse response = resMono.block();
        if(!response.getErrors().isEmpty()){
            log.error(response.getErrors().toString());
            throw new GraphQLException("TrevorBlade GraphQL query error");
        }else {
            return response.toEntity(CountriesData.class);
        }
    }

    @Override
    public Map<String, List<CountryData>> getCountriesByContinent(List<String> codes) {
        return null;
    }
}
