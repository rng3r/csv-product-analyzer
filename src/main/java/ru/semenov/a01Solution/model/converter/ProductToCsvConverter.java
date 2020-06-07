package ru.semenov.a01Solution.model.converter;

import ru.semenov.a01Solution.model.Product;

public class ProductToCsvConverter implements Converter<String, Product> {

    private final String delim;

    public ProductToCsvConverter(String delim) {
        this.delim = delim;
    }

    @Override
    public String convert(Product source) {

        return String.join(delim, String.valueOf(source.getId()), evl(source.getName()), evl(source.getCondition()),
                evl(source.getState()), String.valueOf(source.getPrice()));

    }

    private String evl(String value) {
        return value == null || "".equals(value.trim()) ? "" : value;
    }
}
