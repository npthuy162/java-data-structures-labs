package com.mycompany.printjob;

public class LinkedQueue<E> implements Queue<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {

        Node<E> newest = new Node<>(element, null);

        if (isEmpty()) {
            head = newest;
        } else {
            tail.next = newest;
        }

        tail = newest;
        size++;
    }

    @Override
    public E first() {

        if (isEmpty()) {
            return null;
        }

        return head.element;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            return null;
        }

        E answer = head.element;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return answer;
    }
}
