package lesson3;


public class Missing {
    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
//      int[] arr = {1, 2, 4, 5, 6};
        int n = arr.length;
        System.out.print("Пропущенное число => ");
        System.out.println(findMissingNum(arr, n));
    }

    static int findMissingNum(int[] array, int num) {
        int leftPart = 0, rightPart = num - 1;

        while (leftPart <= rightPart) {
            int middle = (leftPart + rightPart) / 2;

            if (array[middle] != middle + 1 && array[middle - 1] == middle) {
                return (middle + 1);
            }
            if (array[middle] != middle + 1) {
                rightPart = middle - 1;
            } else {
                leftPart = middle + 1;
            }
        }
        return -1;
    }
}





