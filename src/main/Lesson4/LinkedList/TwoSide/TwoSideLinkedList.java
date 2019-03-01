package LinkedList.TwoSide;

import LinkedList.Entry;

interface TwoSideLinkedList<E> {
    void insertLeft(E value);

    void insertRight(E value);

    E removeLeft();

    E removeRight();

    Entry<E> getFirstElement();

    Entry<E> getLastElement();

    E getFirst();

    E getLast();
}
