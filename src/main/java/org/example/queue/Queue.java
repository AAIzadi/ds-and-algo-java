package org.example.queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        Node preLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            preLast.next = last;
        }
        size++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    private class Node {
        Node next;
        T item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private Node start = first;

        @Override
        public boolean hasNext() {
            return start != null;
        }

        @Override
        public T next() {
            T item = start.item;
            start = start.next;
            return item;
        }
    }
}
