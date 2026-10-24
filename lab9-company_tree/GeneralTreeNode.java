package com.mycompany.companytree;

import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {

    String name;
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // Visit parent first, then children
    public void traversePreorder() {
        System.out.println(name);

        for (GeneralTreeNode child : children) {
            child.traversePreorder();
        }
    }

    // Visit children first, then parent
    public void traversePostorder() {
        for (GeneralTreeNode child : children) {
            child.traversePostorder();
        }

        System.out.println(name);
    }
}
