package ru.semenov.a01Solution.model.converter;

import ru.semenov.a01Solution.model.Product;
import ru.semenov.a01Solution.model.converter.Converter;

import java.util.StringTokenizer;

public class CsvToProductConverter implements Converter<Product, String> {

    private final String delim;

    public CsvToProductConverter(String delim) {
        this.delim = delim;
    }


    @Override
    public Product convert(String source) {

        if (source == null || "".equals(source))
            return null;

        StringTokenizer tokenizer = new StringTokenizer(source, delim);

        int position = 0;

        Product.ProductBuilder builder = Product.builder();


        while (tokenizer.hasMoreTokens() && position < 5) {
            String token = tokenizer.nextToken();
            if ("\n".equals(token))
                break;
            switch (position) {
                case 0:
                    builder.id(Integer.parseInt(token));
                    break;
                case 1:
                    builder.name(token);
                    break;
                case 2:
                    builder.condition(token);
                    break;
                case 3:
                    builder.state(token);
                    break;
                case 4:
                    builder.price(Float.parseFloat(token));
                    break;
                default:
                    continue;
            }
            position++;
        }

        return builder.build();
    }

}
