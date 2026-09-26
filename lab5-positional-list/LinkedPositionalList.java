package com.mycompany.positionallist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements Iterable<E> {

    private static class Node<E> implements Position<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public E getElement() {
            return element;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position.");
        }

        Node<E> node = (Node<E>) p;

        if (node.next == null) {
            throw new IllegalArgumentException("Position is no longer valid.");
        }

        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;
        }

        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.next);
    }

    public Position<E> last() {
        return position(trailer.prev);
    }

    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.prev);
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.next);
    }

    private Position<E> addBetween(
            E e, Node<E> prev, Node<E> next) {

        Node<E> newest = new Node<>(e, prev, next);

        prev.next = newest;
        next.prev = newest;
        size++;

        return newest;
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.next);
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.prev, trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.prev, node);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.next);
    }

    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);

        E oldValue = node.element;
        node.element = e;

        return oldValue;
    }

    public E remove(Position<E> p) {
        Node<E> node = validate(p);

        Node<E> prev = node.prev;
        Node<E> next = node.next;

        prev.next = next;
        next.prev = prev;

        size--;

        E oldValue = node.element;

        node.element = null;
        node.prev = null;
        node.next = null;

        return oldValue;
    }

    private class ElementIterator implements Iterator<E> {

        private Position<E> cursor = first();

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if (cursor == null) {
                throw new NoSuchElementException();
            }

            E element = cursor.getElement();
            cursor = after(cursor);

            return element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
