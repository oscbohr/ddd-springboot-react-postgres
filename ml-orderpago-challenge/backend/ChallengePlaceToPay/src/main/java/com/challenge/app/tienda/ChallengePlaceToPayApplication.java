package com.challenge.app.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChallengePlaceToPayApplication {
	
	/**
	 * Bean para consumir otro API REST
	 * @return bean
	 */
    @Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(ChallengePlaceToPayApplication.class, args);
	}

}
