package lesson4.homework;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {
    protected int size;
    protected Node<E> first;

    protected Node<E> findNode(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value)) {
                return current;
            }
        }
        return null;
    }

    @Override
    public void insertFirst(E value) {
        if (isEmpty()) {
            first = new Node<>(value, null, first);
        } else {
            Node<E> node = first;
            first = new Node<>(value, null, first);
            node.prev = first;
        }
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
        node.next = newNode;
        size++;

        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        first.prev = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        if (isEmpty()) { return false; }

        Node<E> node = findNode(value);
        if (node == null) {
            return false;
        } else if (node == first) {
            removeFirst();
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
            size--;
        }
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index == 0) {
            removeFirst();
            return true;
        } else if (index < 0 || index > size) {
            return false;
        }

        Node<E> node = first;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;

        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        if (isEmpty()) {
            return false;
        }
        Node<E> current = findNode(value);
        return current != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);

    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<E>();
    }
    private class ListIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
