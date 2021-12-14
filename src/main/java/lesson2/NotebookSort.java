package lesson2;

public class NotebookSort {

    private final String[] manufacturers = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};// наименования производителей из задания
    private final int[] ramSizes = {4, 8, 12, 16, 20, 24};
    private final int[] prices = new int[30];
    Notebook[] notebooks = new Notebook[10000];

    public NotebookSort() {
        init();
    }

    private int random(int max) {
        return (int) (Math.random() * ++max);
    }

    private String getRandomManufacturer() {
        return manufacturers[random(manufacturers.length - 1)];
    }

    private int getRandomRamSize() {
        return ramSizes[random(ramSizes.length - 1)];
    }

    private int getRandomPriceSize() {
        return prices[random(prices.length - 1)];
    }

    private int getManufacturerSortIndex(String manufacturerName) {
        for (int i = 0; i < manufacturers.length; i++) {
           if(manufacturerName.equals(manufacturers[i])){
               return i;
           }
        }
        return -1;
    }

    private void init() {
        int initPrice = 500;
        int step = 50;
        for (int i = 0; i < prices.length; i++) {
            prices[i] = i * step + initPrice;
        }

        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(getRandomManufacturer(), getRandomRamSize(), getRandomPriceSize());
        }
    }

    private void sortByPrice() {
        for (int i = 0; i < notebooks.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < notebooks.length ; j++) {
                if (notebooks[j].getPrice() < notebooks[min].getPrice()) {
                    min = j;
                }

            }
            Notebook temp = notebooks[i];
            notebooks[i] = notebooks[min];
            notebooks[min] = temp;
        }
    }

    private void sortByRam() {
        for (int i = 0; i < notebooks.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < notebooks.length ; j++) {
                if (notebooks[j].getPrice() == notebooks[min].getPrice() && notebooks[j].getRam() < notebooks[min].getRam()) {
                    min = j;
                }

            }
            Notebook temp = notebooks[i];
            notebooks[i] = notebooks[min];
            notebooks[min] = temp;
        }
    }

    private void sortByManufacturer() {
        for (int i = 0; i < notebooks.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < notebooks.length ; j++) {
                if (notebooks[j].getPrice() == notebooks[min].getPrice() &&
                    notebooks[j].getRam() == notebooks[min].getRam() &&
                    getManufacturerSortIndex(notebooks[j].getManufacturer()) < getManufacturerSortIndex(notebooks[min].getManufacturer())) {
                    min = j;
                }

            }
            Notebook temp = notebooks[i];
            notebooks[i] = notebooks[min];
            notebooks[min] = temp;
        }
    }

    private void printNotebooksArray() {
        for (int i = 0; i < notebooks.length; i++) {
            System.out.println(notebooks[i]);
        }
    }

    public void print() {
        System.out.println("До сортировки...");
        System.out.println("----------------");
        printNotebooksArray();

        sortByPrice();
        System.out.println("");
        System.out.println("После сортировки по цене...");
        System.out.println("----------------");
        printNotebooksArray();

        sortByRam();
        System.out.println("");
        System.out.println("После сортировки по памяти...");
        System.out.println("----------------");
        printNotebooksArray();

        sortByManufacturer();
        System.out.println("");
        System.out.println("После сортировки по производителю...");
        System.out.println("----------------");
        printNotebooksArray();
    }
}
