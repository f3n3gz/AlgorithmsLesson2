package Deck;

public interface Deck<E> {

    boolean insertLeft(E e);

    E removeLeft();

    E peekLeft();

    boolean insertRight(E e);

    E removeRight();

    E peekRight();


    int size();

    boolean isFull();

    boolean isEmpty();

}
