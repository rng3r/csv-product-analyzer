package ru.semenov.a01Solution.analyze;

import ru.semenov.a01Solution.model.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class ConcurrentMapWithAtomicLongCounting implements Counter<Product, AtomicLong> {
    @Override
    public Map<Product, AtomicLong> count(Stream<Product> products) {

        ConcurrentHashMap<Product, AtomicLong> concurrentHashMap = new ConcurrentHashMap<>();

        products.forEach(product -> {
            concurrentHashMap.computeIfAbsent(product, (product1) -> new AtomicLong(0L))
                    .incrementAndGet();
        });

        return concurrentHashMap;

    }
}
