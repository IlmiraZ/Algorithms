package lesson5.backpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final int backpackWeight;
    private int bestPrice;

    private List<Product> bestProducts = null;

    public Backpack(int backpackWeight) {
        this.backpackWeight = backpackWeight;
    }

    private int getWeight(List<Product> products) {
        int result = 0;
        for (Product product : products) {
            result += product.getWeight();
        }
        return result;
    }

    private int getPrice(List<Product> products) {
        int result = 0;
        for (Product product : products) {
            result += product.getPrice();
        }
        return result;
    }

    private void setBestProducts(List<Product> products) {
        if (this.bestProducts == null) {
            if (this.getWeight(products) <= this.backpackWeight) {
                this.bestProducts = products;
                this.bestPrice = this.getPrice(products);
            }
        } else {
            if (this.getWeight(products) <= this.backpackWeight && this.getPrice(products) > this.bestPrice) {
                this.bestProducts = products;
                this.bestPrice = this.getPrice(products);
            }
        }
    }

    public void calcBestProducts(List<Product> products) {
        if (products.size() > 0) {
            this.setBestProducts(products);
        }
        for (int i = 0; i < products.size(); i++) {
            List<Product> newSet = new ArrayList<>(products);
            newSet.remove(i);
            calcBestProducts(newSet);
        }
    }

    public List<Product> getBestProducts() {
        return this.bestProducts;
    }
}
