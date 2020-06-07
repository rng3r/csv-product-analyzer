package ru.semenov.a01Solution.analyze;

import ru.semenov.a01Solution.model.Product;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGroupByAndCounting implements Counter<Product, Long>{
    @Override
    public Map<Product, Long> count(Stream<Product> products) {
        return products
                .sequential()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
