package LinkedList;

public class LinkedListImpl<E> implements LinkedList<E> {

    private Entry<E> firstElement;
    private int size;

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
}
