package ru.f3n3gz.HashTable;

import java.util.Objects;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private transient Entry<?, ?>[] data;
    private int size;
    private int maxSize;

    public HashTableImpl(int maxSize) {
        this.data = new Entry<?, ?>[Math.max(maxSize * 2, 11)];
        this.maxSize = maxSize;
    }

    public HashTableImpl() {
        this(11);
    }

    @Override
    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }

        int hash = key.hashCode();
        int index = hash % maxSize;
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) data[index];
        while (entry != null) {
            if ((entry.hash == hash) && entry.getKey().equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
            entry = entry.next;
        }
        addEntry(hash, key, value, index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) data[index];
        data[index] = new Entry<>(hash, key, value, entry);
        size++;
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % maxSize;
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) data[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int hash = key.hashCode();
        int index = hash % maxSize;
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) data[index];
        for (Entry<K, V> previous = null; entry != null; previous = entry, entry = entry.next) {
            if (entry.getKey().equals(key) && entry.hash == hash) {
                if (previous == null) {
                    data[index] = entry.next;
                } else {
                    previous.next = entry.next;
                }
                size--;
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        if (size == 0) {
            System.out.println("{}");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < maxSize; i++) {
            if (data[i] != null) {
                @SuppressWarnings("unchecked")
                Entry<K, V> entry = (Entry<K, V>) data[i];
                sb.append("( index = ");
                sb.append(i);
                sb.append(" [");
                while (entry != null) {
                    sb.append(" { key = ");
                    sb.append(entry.getKey().toString());
                    sb.append(", value = ");
                    sb.append(entry.getValue());
                    sb.append(" }, ");
                    entry = entry.next;
                }
                sb.replace(sb.length() - 2, sb.length(), "");
                sb.append(" ] )");
            }
        }
        System.out.println(sb.toString());
    }

    private static class Entry<K, V> {
        final K key;
        final int hash;
        private V value;
        private Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key.equals(entry.getKey()) &&
                    value.equals(entry.getValue());
        }

        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }


}
