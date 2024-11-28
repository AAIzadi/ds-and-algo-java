package org.example.stack;

import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T> {
    private Node first;
    private int size;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void push(T value) {
        Node oldNode = first;
        first = new Node();
        first.next = oldNode;
        first.item = value;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedStackIterator();
    }

    private class Node {
        Node next;
        T item;
    }

    private class LinkedStackIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node n = current;
            current = current.next;
            return n.item;
        }
    }
}
