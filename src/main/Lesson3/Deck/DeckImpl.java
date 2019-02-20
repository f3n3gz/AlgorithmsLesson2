package Deck;

public class DeckImpl<E> implements Deck<E> {
    private int size;
    private E[] data;
    private int leftCorner;
    private int rightCorner;
    private int queueLenght;

    public DeckImpl(int maxSize) {
        queueLenght = maxSize;
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean insertLeft(E e) {
        if (this.isFull()) {
            return false;
        }
        if (this.isEmpty()) {
            return insertFirstElement(e);
        }
        leftCorner = (queueLenght + (--leftCorner)) % queueLenght;
        data[leftCorner] = e;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E e) {
        if (this.isFull()) {
            return false;
        }
        if (this.isEmpty()) {
            return insertFirstElement(e);
        }
        rightCorner = (++rightCorner) % (queueLenght - 1);
        data[rightCorner] = e;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (this.isEmpty()) {
            return null;
        }
        E temp = data[leftCorner++];
        leftCorner = leftCorner % (queueLenght - 1);
        size--;
        return temp;
    }

    @Override
    public E peekLeft() {
        if (this.isEmpty()) {
            return null;
        }
        return data[leftCorner];
    }


    @Override
    public E removeRight() {
        if (this.isEmpty()) {
            return null;
        }
        E temp = data[rightCorner--];
        rightCorner = (queueLenght + rightCorner) % queueLenght;
        size--;
        return temp;
    }

    @Override
    public E peekRight() {
        if (this.isEmpty()) {
            return null;
        }
        return data[rightCorner];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean insertFirstElement(E e) {
        leftCorner = 0;
        rightCorner = 0;
        data[rightCorner] = e;
        size++;
        return true;
    }
}
