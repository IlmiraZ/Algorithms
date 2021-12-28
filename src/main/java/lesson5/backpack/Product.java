package lesson5.backpack;

public class Product {
    private final String name;
    private final int weight;
    private final int price;

    public Product(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name= " + name +
                ", weight=" + weight +
                ", price=" + price +
                "}";
    }
}
