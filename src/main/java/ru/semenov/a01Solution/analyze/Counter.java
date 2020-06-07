package ru.semenov.a01Solution.analyze;

import ru.semenov.a01Solution.model.Product;

import java.util.Map;
import java.util.stream.Stream;

public interface Counter<T, C> {

    Map<T, C> count(Stream<T> products);

}
