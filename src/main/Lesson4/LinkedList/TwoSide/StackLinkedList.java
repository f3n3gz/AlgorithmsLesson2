package LinkedList.TwoSide;

import LinkedList.LinkedList;
import LinkedList.LinkedListImpl;
import Stack.Stack;

public class StackLinkedList<E> implements Stack {
    private final LinkedList<E> data;
    private int size;
    private int maxSize;

    public StackLinkedList(int stackSize) {
        this.data = new LinkedListImpl<E>();
        this.maxSize = stackSize;
    }

    @Override
    public boolean push(Object value) {
        if (++size > maxSize) {
            size--;
            return false;
        }
        data.insert((E) value);
        return true;
    }

    @Override
    public Object pop() {
        size--;
        return data.remove();
    }

    @Override
    public Object peek() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
