package ru.semenov.a01Solution;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import ru.semenov.a01Solution.model.Product;


public class ProductFootprint {

    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(Product.class).toPrintable());
    }


}
