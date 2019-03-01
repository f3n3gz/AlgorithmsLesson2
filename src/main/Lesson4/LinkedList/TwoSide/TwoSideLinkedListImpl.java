package LinkedList.TwoSide;


import LinkedList.Entry;
import LinkedList.LinkedListImpl;

public class TwoSideLinkedListImpl<E> extends LinkedListImpl<E> implements TwoSideLinkedList<E> {

    private Entry<E> lastElement;


    @Override
    public void insertLeft(E value) {
        Entry<E> newElement = new Entry<E>(value);
        firstElement.setPrev(newElement);
        newElement.setNext(firstElement);
        this.firstElement = newElement;
        size++;
        if (getSize() == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertRight(E value) {
        if (size == 0) {
            insertLeft(value);
        } else {
            Entry<E> newEntry = new Entry<>(value);
            lastElement.setNext(newEntry);
            newEntry.setPrev(lastElement);
            lastElement = newEntry;
        }


    }

    @Override
    public E removeLeft() {
        E removedElement = remove();
        if (isEmpty()) {
            lastElement = null;
        }
        size--;
        return removedElement;
    }

    @Override
    public E removeRight() {
        Entry<E> removedElement = lastElement;
        Entry<E> prevElement = lastElement.getPrev();
        prevElement.setNext(null);
        size--;
        return removedElement.getValue();
    }

    public boolean remove(E value) {
        Entry<E> currentEntry = firstElement;
        Entry<E> previousEntry = null;
        Entry<E> nextEntry = null;
        while (currentEntry != null) {
            if (currentEntry.getValue().equals(value)) {
                if (previousEntry == null) {
                    firstElement = null;
                    lastElement = null;
                } else {
                    nextEntry = currentEntry.getNext();
                    if (nextEntry != null) {
                        nextEntry.setPrev(previousEntry);
                    }
                    previousEntry.setNext(nextEntry);

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
    public Entry<E> getLastElement() {
        return lastElement;
    }

    @Override
    public E getLast() {
        return lastElement.getValue();
    }
}
