package ru.semenov.a01Solution.model.converter;

public interface Converter<T, S> {

    T convert(S source);

}
