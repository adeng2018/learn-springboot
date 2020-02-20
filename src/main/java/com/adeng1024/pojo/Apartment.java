package com.adeng1024.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Apartment {
    private String id;
    private String name;

    public Apartment(String id) {
        this.id = id;
    }

    public Apartment() {
    }

    public Apartment(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
