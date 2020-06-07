package ru.semenov.a01Solution;

import org.junit.Test;
import ru.semenov.a01Solution.model.Product;
import ru.semenov.a01Solution.model.converter.ProductToCsvConverter;

import static org.junit.Assert.*;

public class ProductToCsvConverterTest {

    ProductToCsvConverter productToCsvConverter = new ProductToCsvConverter(";");

    @Test
    public void testConvertFilled() {

        Product product = new Product(1, "1", "1", "1", 1.0F);

        String output = productToCsvConverter.convert(product);

        assertEquals("1;1;1;1;1.0", output);

    }

    @Test
    public void testConvertedPartiallyFilled() {

        Product product = new Product(1, "", "", "", 1.0F);

        String output = productToCsvConverter.convert(product);

        assertEquals("1;;;;1.0", output);

    }

    @Test
    public void testConvertedPartiallyFilledAndNulls() {

        Product product = new Product(1, null, "", null, 1.0F);

        String output = productToCsvConverter.convert(product);

        assertEquals("1;;;;1.0", output);

    }





}