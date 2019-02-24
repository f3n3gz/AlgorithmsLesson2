package Queue;

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peek();

    int size();

    boolean isFull();

    boolean isEmpty();
}
