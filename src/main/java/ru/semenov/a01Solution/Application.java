package ru.semenov.a01Solution;

import ru.semenov.a01Solution.analyze.ConcurrentMapWithAtomicLongCounting;
import ru.semenov.a01Solution.model.Product;
import ru.semenov.a01Solution.model.converter.CsvToProductConverter;
import ru.semenov.a01Solution.model.converter.ProductToCsvConverter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws IOException {

        Path directory = Paths.get(".");

        String delim = ";";

        CsvToProductConverter csvToProductConverter = new CsvToProductConverter(delim);

        Stream<Product> products = Files
                .list(directory)
                .parallel()
                .filter(path -> path.getFileName().toFile().getName().endsWith("csv"))
                .flatMap(filePath -> {
                    try {
                        return Files.lines(filePath, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Stream.empty();
                    }
                })
                .map(csvToProductConverter::convert)
                .filter(Objects::nonNull);


        Map<Product, AtomicLong> productCountsMap = new ConcurrentMapWithAtomicLongCounting().count(products);


        List<Product> cheapest1000NoMore20TimesProducts = productCountsMap.entrySet().stream()
                .parallel()
                .filter(entry -> entry.getValue().get() <= 20)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(1000)
                .collect(Collectors.toList());


        ProductToCsvConverter productToCsvConverter = new ProductToCsvConverter(delim);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("output.csv"), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING)){

            for (Product product : cheapest1000NoMore20TimesProducts) {

                bufferedWriter.write(productToCsvConverter.convert(product));
                bufferedWriter.newLine();

            }

        }

    }

}
