package LinkedList;

import java.util.Objects;

public class Entry<E> {

    private final E value;
    private Entry<E> next;
    private Entry<E> prev;

    public Entry(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public Entry<E> getNext() {
        return next;
    }

    public void setNext(Entry<E> next) {
        this.next = next;
    }

    public Entry<E> getPrev() {
        return prev;
    }

    public void setPrev(Entry<E> prev) {
        this.prev = prev;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?> entry = (Entry<?>) o;
        return value.equals(entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Entry{ value= " + value + " }";
    }
}
