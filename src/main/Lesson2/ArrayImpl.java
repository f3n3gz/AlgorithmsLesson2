import java.util.Arrays;

public class ArrayImpl<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 8;
    private static final int WRONG_INDEX = -1;
    private int size;
    private Object[] data;

    public ArrayImpl() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public ArrayImpl(int initialCapacity) {
        if (initialCapacity > 0) {
            data = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        }
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        data[size++] = e;
    }

    public void removeByIndex(int index) {
        if (!rangeCheck(index)) {
            throw new IllegalArgumentException("Wrong index of element");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void removeByValue(E element) {
        removeByIndex(search(element));
    }

    public int search(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return WRONG_INDEX;
    }

    public E get(int index) {
        if (rangeCheck(index)) {
            return (E) data[index];
        } else {
            throw new IllegalArgumentException("Index out of range: " + index);
        }
    }

    private boolean rangeCheck(int index) {
        return !(index < 0 || index > size);
    }

    private void ensureCapacity(int necessaryCapacity) {
        if (necessaryCapacity > data.length) {
            increaseCapacity(necessaryCapacity);
        }
    }

    private void increaseCapacity(int necessaryCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity * 2;
        if (newCapacity < DEFAULT_CAPACITY) {
            newCapacity = DEFAULT_CAPACITY;
        }
        data = Arrays.copyOf(data, newCapacity);
    }

    public int size() {
        return size;
    }
}
