package ru.f3n3gz.Tree;

public interface Tree<E extends Comparable<? super E>> {
    void add(E element);

    boolean remove(E element);

    boolean find(E element);

    void display();

    boolean isEmpty();

    void traverse(TraverseMode traverseMode);

    boolean isBalanced();

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }
}
