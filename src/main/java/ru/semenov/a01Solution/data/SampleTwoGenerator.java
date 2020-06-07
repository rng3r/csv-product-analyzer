package ru.semenov.a01Solution.data;

import ru.semenov.a01Solution.model.converter.ProductToCsvConverter;
import ru.semenov.a01Solution.model.Product;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SampleTwoGenerator {

    private static final List<Product> DATASET = new ArrayList<Product>() {{
        addAll(IntStream.rangeClosed(0, 25)
                .mapToObj(number -> new Product(number, String.valueOf(number), String.valueOf(number), String.valueOf(number), (float) number))
                .collect(Collectors.toList()))
        ;
    }};

    private static final List<Product> DATASET_NO_NORE_20 = new ArrayList<Product>() {{
        addAll(IntStream.rangeClosed(27, 100)
                .mapToObj(number -> new Product(number, String.valueOf(number), String.valueOf(number), String.valueOf(number), (float) number))
                .collect(Collectors.toList()))
        ;
    }};


    public static void main(String[] args) throws IOException {

        Random random = new Random();

        ProductToCsvConverter productToCsvConverter = new ProductToCsvConverter(";");

        try (BufferedWriter sample = Files.newBufferedWriter(Paths.get("samples","sample2", "sampleTwoFile.csv"), StandardOpenOption.CREATE_NEW)) {

            IntStream.range(1, 100000)
                    .map(number -> random.nextInt(26))
                    .mapToObj(DATASET::get)
                    .map(productToCsvConverter::convert)
                    .forEach(string -> {
                        try {
                            sample.write(string);
                            sample.newLine();
                        }
                        catch (IOException e) {
                            //ignore
                        }
                    });

            DATASET_NO_NORE_20.stream()
                    .map(productToCsvConverter::convert)
                    .forEach(string -> {
                        try {
                            sample.write(string);
                            sample.newLine();
                        }
                        catch (IOException e) {
                            //ignore
                        }
                    });

        }


        ;




    }



}
