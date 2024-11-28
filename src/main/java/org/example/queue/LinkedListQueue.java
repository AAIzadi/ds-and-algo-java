package org.example.queue;

import java.util.Iterator;

public class LinkedListQueue<T> implements Iterable<T> {
    Node head;
    Node tail;
    int size;

    public LinkedListQueue() {
    }

    public void push(T x) {
        Node node = new Node(x);
        if (empty()) {
            head = node;
        } else {
            node.next = tail;
            tail.prev = node;
        }
        tail = node;
        size++;
    }

    public T pop() {
        Node h = head;
        head = head.prev;
        head.next = null;
        size--;
        return h.data;
    }

    public T peek() {
        return head.data;
    }

    public boolean empty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<T> {

        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.data;
            current = current.prev;
            return item;
        }
    }

    private class Node {

        public Node(T data) {
            this.data = data;
        }

        Node next;
        Node prev;
        T data;
    }

}
