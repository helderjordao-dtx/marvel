package com.java.marvel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.java.marvel.repository.ItemRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MarvelApplication {

	@Autowired
	ItemRepository marvelCharactersRepo;

	@Value("${api.timeout}")
	private int apiTimeout;

	public static void main(String[] args) {
		SpringApplication.run(MarvelApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		var factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(apiTimeout);
		factory.setReadTimeout(apiTimeout);
		return new RestTemplate(factory);
	}
}
