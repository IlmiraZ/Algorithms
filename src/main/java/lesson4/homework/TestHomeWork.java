package lesson4.homework;

public class TestHomeWork {
    public static void main(String[] args) {
        testDeque();

    }

    private static void testDeque() {
        Deque<Integer> deque = new LinkedDeque<>();

        System.out.println("add element: " + deque.insert(1));
        System.out.println("add element: " + deque.insert(2));
        System.out.println("add element: " + deque.insert(3));
        System.out.println("add element: " + deque.insert(4));
        System.out.println("add element: " + deque.insert(5));
        System.out.println("add element: " + deque.insert(6));

        deque.display();
        System.out.println("remove: " + deque.remove(2));
        System.out.println("remove: " + deque.remove(4));
        System.out.println("remove: " + deque.remove(5));
        deque.display();
    }
}
