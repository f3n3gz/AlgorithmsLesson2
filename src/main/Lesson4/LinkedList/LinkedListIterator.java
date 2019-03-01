package LinkedList;

import java.util.Iterator;

public interface LinkedListIterator<E> extends Iterator<E> {
    void reset();

    void nextLink();

    E getCurrent();

    boolean atEnd();

    void insertAfter(E e);

    void insertBefore(E e);

    void deleteCurrent();
}
