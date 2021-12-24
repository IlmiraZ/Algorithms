package lesson4.homework;

import lesson4.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insert(E value, int index);

    boolean remove(int index);

    E remove();
}