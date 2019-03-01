package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Entry<E> firstElement;
    protected int size;

    @Override
    public void insert(E value) {
        Entry<E> newElement = new Entry<E>(value);
        newElement.setNext(firstElement);
        this.firstElement = newElement;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        Entry<E> removedElement = firstElement;
        firstElement = firstElement.getNext();
        size--;
        return removedElement.getValue();
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean find(E value) {
        Entry<E> currentEntry = firstElement;
        while (currentEntry != null) {
            if (currentEntry.getValue().equals(value)) {
                return true;
            }
            currentEntry = currentEntry.getNext();
        }
        return false;
    }

    @Override
    public void display() {
        Entry<E> currentEntry = firstElement;
        System.out.println("------");
        System.out.println(this.getClass().getSimpleName());
        while (currentEntry != null) {
            System.out.println(currentEntry.getValue());
            currentEntry = currentEntry.getNext();
        }
        System.out.println("------");
    }

    @Override
    public Entry<E> getFirstElement() {
        return firstElement;
    }

    @Override
    public E getFirst() {
        return firstElement.getValue();
    }

    public boolean remove(E value) {
        Entry<E> currentEntry = firstElement;
        Entry<E> previousEntry = null;

        while (currentEntry != null) {
            if (currentEntry.getValue().equals(value)) {
                if (previousEntry == null) {
                    firstElement = null;
                } else {
                    previousEntry.setNext(currentEntry.getNext());
                }
                size--;
                return true;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.getNext();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIteratorImpl();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        for (E e : this) {
            action.accept(e);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    private class LinkedListIteratorImpl implements LinkedListIterator<E> {
        private Entry<E> prev;
        private Entry<E> current;
        private Entry<E> next;

        public LinkedListIteratorImpl() {
            next = getFirstElement();
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public synchronized E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            prev = current;
            current = next;
            next = current.getNext();
            return current.getValue();
        }

        @Override
        public synchronized void remove() {
            if (prev != null) {
                prev.setNext(next);
            }
            current = next;
            if (current != null) {
                next = current.getNext();
            }


        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (hasNext()) {
                action.accept(next.getValue());
                next();
            }
        }

        public void reset() {
            prev = null;
            current = null;
            next = firstElement;
        }

        public void nextLink() {
            next();
        }

        public E getCurrent() {
            if (current == null) {
                throw new IllegalStateException();
            }
            return current.getValue();
        }

        public boolean atEnd() {
            return next == null;
        }

        public void insertAfter(E e) {
            Entry<E> newEntry = new Entry<E>(e);
            if (current != null) {
                newEntry.setNext(current.getNext());
                current.setNext(newEntry);
            }
        }

        public void insertBefore(E e) {
            Entry<E> newEntry = new Entry<E>(e);
            if (current != null) {
                if (current == firstElement) {
                    newEntry.setNext(current);
                    firstElement = newEntry;
                } else {
                    prev.setNext(newEntry);
                    newEntry.setNext(current);
                }

            }
        }

        public void deleteCurrent() {
            remove();
        }
    }
}
