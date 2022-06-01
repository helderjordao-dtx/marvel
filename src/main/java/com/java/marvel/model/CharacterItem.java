package com.java.marvel.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("characteritems")
public class CharacterItem {

    @Id
    private String id;

    private String name;
    private String description;
    private String thumbnail;

    public CharacterItem(String id, String name, String description, String thumbnail) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

}
