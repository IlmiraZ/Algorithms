package lesson5;

import lesson5.backpack.Backpack;
import lesson5.backpack.Product;

import java.util.ArrayList;
import java.util.List;

import static lesson5.power.Power.power;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("task № 1");
        System.out.println(power(5, -3));
        System.out.println(power(5, 2));

        System.out.println("");
        System.out.println("task № 2");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Ноутбук", 2, 50000));
        products.add(new Product("Утюг", 1, 600));
        products.add(new Product("Кастрюля", 1, 5000));
        products.add(new Product("Гиря", 5, 500));
        products.add(new Product("Колонка", 4, 10000));

        Backpack backpack = new Backpack(7);
        backpack.calcBestProducts(products);
        System.out.println("ALL PRODUCTS:");
        printList(products);
        System.out.println("==========================================");
        System.out.println("BEST PRODUCTS:");
        printList(backpack.getBestProducts());

    }

    private static void printList(List<Product> products) {
        for (Product product : products) {
            System.out.println("  " + product);
        }
    }
}
