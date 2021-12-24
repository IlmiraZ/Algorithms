package lesson4.homework;

public interface LinkedList<E> {

    void insertFirst(E value);

    boolean insert(E value, int index);

    E removeFirst();

    boolean remove(E value);

    boolean remove(int index);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        E item;
        LinkedList.Node<E> prev;
        LinkedList.Node<E> next;

        public Node(E item, LinkedList.Node<E> prev, LinkedList.Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
