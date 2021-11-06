package com.mongodb.mongo_spring.model;

public enum SearchType {
    ID("searchById"), EMAIL("searchByEmail");

    SearchType(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }
}
