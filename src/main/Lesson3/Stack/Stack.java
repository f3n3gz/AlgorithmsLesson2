package Stack;

public interface Stack<E> {
    boolean push(E value);

    E pop();

    E peek();

    int size();

    boolean isFull();

    boolean isEmpty();
}
