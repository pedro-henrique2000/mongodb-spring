package com.mongodb.mongo_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchRequest {

    private SearchType type;
    private String value;

}
