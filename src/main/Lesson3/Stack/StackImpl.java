package Stack;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private int size;

    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean push(E value) {
        if (this.isFull()) {
            return false;
        }
        data[size++] = value;
        return true;
    }

    @Override
    public E pop() {
        return data[--size];
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return (size == data.length);
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
}
