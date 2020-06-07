package ru.semenov.a01Solution.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Builder
@Data
@RequiredArgsConstructor
public class Product {

    private final int id;
    private final String name;
    private final String condition;
    private final String state;
    private final float price;

}
