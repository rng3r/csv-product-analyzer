package ru.semenov.a01Solution;

import org.junit.Test;
import ru.semenov.a01Solution.model.Product;
import ru.semenov.a01Solution.model.converter.CsvToProductConverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CsvToProductConverterTest {

    private final CsvToProductConverter csvToProductConverter = new CsvToProductConverter(";");

    @Test
    public void testAllFiveValues() {

        String source = "1;1;1;1;1;\n";

        Product product = csvToProductConverter.convert(source);

        assertEquals(1, product.getId());
        assertEquals("1", product.getName());
        assertEquals("1", product.getCondition());
        assertEquals("1", product.getState());
        assertEquals(1.0F, product.getPrice(), 0.0F);

    }

    @Test
    public void testMoreFiveValues() {
        String source = "1;1;1;1;1;1;1;1;1;1;\n";

        Product product = csvToProductConverter.convert(source);

        assertEquals(1, product.getId());
        assertEquals("1", product.getName());
        assertEquals("1", product.getCondition());
        assertEquals("1", product.getState());
        assertEquals(1.0F, product.getPrice(), 0.0F);
    }

    @Test
    public void testOnlyId() {
        String source = "1;\n";

        Product product = csvToProductConverter.convert(source);

        assertEquals(1, product.getId());
        assertNull(null, product.getName());
        assertNull(null, product.getCondition());
        assertNull(null, product.getState());
        assertEquals(0.0F, product.getPrice(), 0.0F);

    }

    @Test
    public void testOnlyIdAndName() {
        String source = "1;1;\n";

        Product product = csvToProductConverter.convert(source);

        assertEquals(1, product.getId());
        assertEquals("1", product.getName());
        assertNull(null, product.getCondition());
        assertNull(null, product.getState());
        assertEquals(0.0F, product.getPrice(), 0.0F);

    }


}