package com.java.marvel.repository;

import com.java.marvel.model.CharacterItem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ItemRepository extends MongoRepository<CharacterItem, String> {
    @Query("{id:'?0'}")
    CharacterItem findItemById (String id);
}
