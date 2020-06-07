package ru.semenov.a01Solution.analyze;

import org.junit.Test;
import ru.semenov.a01Solution.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamGroupByAndCountingTest extends LargeDataTest {

    @Test
    public void testStreamConcurrent_max_100_000_000() {

        Random random = new Random();

        int maxStreamElements = 100_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        StreamGroupByAndCounting streamGroupByAndCounting = new StreamGroupByAndCounting();

        long start = System.currentTimeMillis();
        streamGroupByAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_max_10_000_000() {

        Random random = new Random();

        int maxStreamElements = 10_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        StreamGroupByAndCounting streamGroupByAndCounting = new StreamGroupByAndCounting();

        long start = System.currentTimeMillis();
        streamGroupByAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_max_1_000_000() {

        Random random = new Random();

        int maxStreamElements = 1_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        StreamGroupByAndCounting streamGroupByAndCounting = new StreamGroupByAndCounting();

        long start = System.currentTimeMillis();
        streamGroupByAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_max_1_000_000_000() {

        Random random = new Random();

        int maxStreamElements = 1_000_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        StreamGroupByAndCounting streamGroupByAndCounting = new StreamGroupByAndCounting();

        long start = System.currentTimeMillis();
        streamGroupByAndCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("StreamGroupByAndCountingTest random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }



}