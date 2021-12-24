package lesson4.homework;

public class LinkedDeque<E> implements Deque<E> {

    private final TwoSideLinkedList<E> data;

    public LinkedDeque() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insert(E value, int index) {
        return data.insert(value, index);
    }

    @Override
    public boolean remove(int index) {
        return data.remove(index);
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedDeque{" +
                "data=" + data +
                '}';
    }
}
