package ru.f3n3gz.HashTable;

interface HashTable<K, V> {
    V put(K key, V value);

    V get(K key);

    V remove(K key);

    int getSize();

    boolean isEmpty();

    void display();
}
