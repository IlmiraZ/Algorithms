package lesson4.homework;

import java.util.Iterator;

public class TestHomeWork {
    public static void main(String[] args) {
        testDeque();
        testIterator();
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

    private static void testIterator() {
        SimpleLinkedListImpl<Integer> linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);


        System.out.println("Начальный список: ");
        for (Integer value : linkedList) {
            System.out.println(value);
        }
        System.out.println("---------------");
        System.out.println("Удаление элемента со значением = 4");
        System.out.println("---------------");
        Iterator<Integer> iterator1 = linkedList.iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() == 4) {
                iterator1.remove();
            }
        }

        System.out.println("Список после удаления: ");
        for(Integer integer : linkedList) {
            System.out.println(integer);
        }

    }
}
