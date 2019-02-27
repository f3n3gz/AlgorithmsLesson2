package LinkedList.TwoSide;


import LinkedList.LinkedList;
import LinkedList.LinkedListImpl;
import Queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {

    private LinkedList<E> data;

    public LinkedQueueImpl() {
        data = new LinkedListImpl<E>();
    }


    @Override
    public boolean insert(E value) {
        data.insert(value);
        return true;
    }

    @Override
    public E remove() {
        return data.remove();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
