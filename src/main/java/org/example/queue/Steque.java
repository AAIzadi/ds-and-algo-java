package org.example.queue;

import java.util.Iterator;

public class Steque<T> implements Iterable<T> {
    Node head;
    Node tail;
    int size;

    public void push(T element) {
        if (isEmpty()) {
            Node newNode = new Node(element);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            Node oldHead = head;
            Node newNode = new Node(element);
            newNode.next = oldHead;
            head = newNode;
            size++;
        }
    }

    public void enqueue(T element) {
        if (isEmpty()) {
            Node newNode = new Node(element);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            var newTail = new Node(element);
            tail.next = newTail;
            tail = newTail;
        }

    }

//    public T pop() {
//
//    }

    private boolean isEmpty() {
        return head == null && tail == null;
    }

    private class Node {

        public Node(T element) {
            item = element;
        }

        Node next;
        T item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<T> {

        Node first = head;

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public T next() {   
            Node currentNode = first;
            first = first.next;
            return currentNode.item;
        }
    }
}
