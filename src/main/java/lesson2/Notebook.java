package lesson2;

public class Notebook implements Comparable<Notebook> {
    private final int price;
    private final String manufacturer;
    private final int ram;

    public Notebook(String manufacturer, int ram, int price) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.ram = ram;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "manufacturer='" + manufacturer + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Notebook o) {
        int comparePrice = o.getPrice();
        return this.getPrice() - comparePrice;
    }
}
