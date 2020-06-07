package ru.semenov.a01Solution.analyze;

import org.junit.Test;
import ru.semenov.a01Solution.model.Product;

import java.util.stream.Stream;

public class StreamGroupByConcurrentAndCountingTest extends LargeDataTest{

    @Test
    public void testStreamConcurrent_100_000_000_elements_of_100_000() {

        StreamGroupByConcurrentAndCounting streamGroupByConcurrentAndCounting = new StreamGroupByConcurrentAndCounting();
        int maxStreamElements = 100_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);


        long start = System.currentTimeMillis();
        streamGroupByConcurrentAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByConcurrentAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements + ") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_10_000_000_elements_of_100_000() {

        StreamGroupByConcurrentAndCounting streamGroupByConcurrentAndCounting = new StreamGroupByConcurrentAndCounting();
        int maxStreamElements = 10_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);


        long start = System.currentTimeMillis();
        streamGroupByConcurrentAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByConcurrentAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements + ") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_1_000_000_elements_of_100_000() {

        StreamGroupByConcurrentAndCounting streamGroupByConcurrentAndCounting = new StreamGroupByConcurrentAndCounting();
        int maxStreamElements = 1_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);


        long start = System.currentTimeMillis();
        streamGroupByConcurrentAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByConcurrentAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements + ") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_1_000_000_000_elements_of_100_000() {

        StreamGroupByConcurrentAndCounting streamGroupByConcurrentAndCounting = new StreamGroupByConcurrentAndCounting();
        int maxStreamElements = 1_000_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);


        long start = System.currentTimeMillis();
        streamGroupByConcurrentAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByConcurrentAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements + ") -> " + (end - start) + " ms");
    }








}