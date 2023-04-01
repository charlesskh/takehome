package com.example.takehome.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class GraphqlClientConfig {

    @Value("${takehome.trevorblades.url}")
    private String trevorBladesUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Bean
    public HttpGraphQlClient trevorBladesGraphQLClient(){
        return HttpGraphQlClient.builder(webClientBuilder)
                .url(trevorBladesUrl+"/graphql")
                .build();
    }
}
