package ru.semenov.a01Solution.analyze;

import org.junit.Test;
import ru.semenov.a01Solution.model.Product;

import java.util.Random;
import java.util.stream.Stream;

public class ConcurrentMapWithAtomicLongCountingTest extends LargeDataTest{

    @Test
    public void testStreamConcurrent_max_100_000_000() {

        Random random = new Random();

        int maxStreamElements = 100_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        ConcurrentMapWithAtomicLongCounting concurrentMapWithAtomicLongCounting = new ConcurrentMapWithAtomicLongCounting();

        long start = System.currentTimeMillis();
        concurrentMapWithAtomicLongCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("ConcurrentMapWithAtomicLongCounting random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_max_10_000_000() {


        int maxStreamElements = 10_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        ConcurrentMapWithAtomicLongCounting concurrentMapWithAtomicLongCounting = new ConcurrentMapWithAtomicLongCounting();

        long start = System.currentTimeMillis();
        concurrentMapWithAtomicLongCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("ConcurrentMapWithAtomicLongCounting random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_max_1_000_000() {

        Random random = new Random();

        int maxStreamElements = 1_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        ConcurrentMapWithAtomicLongCounting concurrentMapWithAtomicLongCounting = new ConcurrentMapWithAtomicLongCounting();

        long start = System.currentTimeMillis();
        concurrentMapWithAtomicLongCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("ConcurrentMapWithAtomicLongCounting random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }

    @Test
    public void testStreamConcurrent_max_1_000_000_000() {

        Random random = new Random();

        int maxStreamElements = 1_000_000_000;
        int maxSamples = 100_000;
        Stream<Product> products = generateStream(maxStreamElements, maxSamples);

        ConcurrentMapWithAtomicLongCounting concurrentMapWithAtomicLongCounting = new ConcurrentMapWithAtomicLongCounting();

        long start = System.currentTimeMillis();
        concurrentMapWithAtomicLongCounting.count(products);
        long end = System.currentTimeMillis();

        System.out.println("ConcurrentMapWithAtomicLongCounting random of " + maxSamples + " for [0, " + maxStreamElements +") -> " + (end - start) + " ms");
    }





}