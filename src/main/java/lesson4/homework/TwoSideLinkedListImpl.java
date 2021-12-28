package lesson4.homework;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value, last, null);

        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public boolean insert(E value, int index) {
        if (index == 0) {
            insertFirst(value);
            return true;
        } else if (index < 0 || index > size) {
            return false;
        }

        Node<E> node = first;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node<E> newNode = new Node<>(value, node, node.next);
        if (node == last) {
            last = newNode;
        }
        node.next = newNode;

        size++;

        return true;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            last = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> node = findNode(value);
        if (node == null) {
            return false;
        } else if (node == first) {
            removeFirst();
            return true;
        } else if (node == last) {
            last = node.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
        size--;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index == 0) {
            removeFirst();
            return true;
        } else if (index < 0 || index >= size) {
            return false;
        }

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node == last) {
            last = node.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;

        size--;

        return true;
    }

    @Override
    public E getLast() {
        return last.item;
    }

}
