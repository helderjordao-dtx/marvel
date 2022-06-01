package com.java.marvel;

import com.java.marvel.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MarvelApplication {

	@Autowired
	ItemRepository marvelCharactersRepo;

	public static void main(String[] args) {
		SpringApplication.run(MarvelApplication.class, args);
	}

}
