package com.mycompany.codesyntax;

public class ArrayStack<E> implements Stack<E> {

    private final E[] data;
    private int top = -1;

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E element) {
        if (top == data.length - 1) {
            throw new IllegalStateException("Stack is full.");
        }

        data[++top] = element;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }

        return data[top];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E answer = data[top];
        data[top] = null;
        top--;

        return answer;
    }
}
