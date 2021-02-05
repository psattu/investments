package com.tandra.investment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TandraInvestmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TandraInvestmentApplication.class, args);
    }


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
