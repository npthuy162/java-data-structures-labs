package com.mycompany.codesyntax;

public interface Stack<E> {

    int size();

    boolean isEmpty();

    void push(E element);

    E top();

    E pop();
}
