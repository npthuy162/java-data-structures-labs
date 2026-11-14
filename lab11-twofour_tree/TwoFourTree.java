package com.mycompany.twofourtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isFull() {
        return keys.size() == 3;
    }

    public int getKeyCount() {
        return keys.size();
    }

    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        insert(root, key);
    }

    private void insert(TwoFourNode start, int key) {
        TwoFourNode node = start;

        while (!node.isLeaf()) {
            if (node.keys.contains(key)) {
                return;
            }
            node = node.getNextChild(key);
        }

        if (node.keys.contains(key)) {
            return;
        }

        node.insertKey(key);

        while (node != null && node.keys.size() > 3) {
            node = split(node);
        }
    }

    private TwoFourNode split(TwoFourNode node) {
        System.out.println("Splitting node with keys: " + node.keys);

        // Promote the second key
        int middleKey = node.keys.get(1);

        TwoFourNode rightNode = new TwoFourNode();

        // Move larger keys to the right node
        rightNode.keys.addAll(
                new ArrayList<>(node.keys.subList(2, node.keys.size()))
        );

        // Keep the smallest key in the left node
        node.keys.subList(1, node.keys.size()).clear();

        // Redistribute children if this is an internal node
        if (!node.isLeaf()) {
            List<TwoFourNode> movedChildren =
                    new ArrayList<>(node.children.subList(2, node.children.size()));

            node.children.subList(2, node.children.size()).clear();

            for (TwoFourNode child : movedChildren) {
                rightNode.children.add(child);
                child.parent = rightNode;
            }
        }

        // Create a new root when the old root splits
        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();

            newRoot.keys.add(middleKey);
            newRoot.children.add(node);
            newRoot.children.add(rightNode);

            node.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;

            return newRoot;
        }

        // Insert promoted key into existing parent
        TwoFourNode parent = node.parent;
        int index = parent.children.indexOf(node);

        parent.keys.add(index, middleKey);
        parent.children.add(index + 1, rightNode);
        rightNode.parent = parent;

        return parent;
    }

    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) {
            return;
        }

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            for (int i = 0; i < node.keys.size(); i++) {
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            inorder(node.children.get(node.keys.size()));
        }
    }
}
