package ru.semenov.a01Solution.analyze;

import ru.semenov.a01Solution.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class LargeDataTest {


    protected Stream<Product> generateStream(int maxStreamElements, int maxSamples) {

//        List<Product> products = new ArrayList<>();
//        products.addAll(IntStream.rangeClosed(0, maxSamples)
//                .mapToObj(number -> new Product(number, String.valueOf(number), String.valueOf(number), String.valueOf(number), (float) number))
//                .collect(Collectors.toList()));
//
        Random random = new Random();

        return IntStream.range(0, maxStreamElements)
                .parallel()
                .mapToObj(i -> {
                    int number = random.nextInt(maxSamples);
                    return new Product(number, String.valueOf(number), String.valueOf(number), String.valueOf(number), (float) number);
                });

    }


}
