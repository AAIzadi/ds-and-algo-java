package org.example.stack;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T> {
    private T[] items;
    private int size;


    @SuppressWarnings("unchecked")
    public ArrayStack() {
        items = (T[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        if (size == items.length) resize(2 * items.length);
        items[size++] = item;
    }

    public T pop() {
        T item = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length / 4) resize(items.length / 2);
        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        if (size >= 0) System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i < size;
        }

        public T next() {
            return items[i++];
        }
    }
}
