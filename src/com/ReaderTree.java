
package com;

import java.util.ArrayList;

public class ReaderTree {
    
    private ReaderNode firstNode = null;
    
    private static final ReaderTree treeInstance = new ReaderTree();
    
    private ReaderTree() { }
    
    public static ReaderTree getTree() {
        return treeInstance;
    }
    
    public boolean isEmpty() { return (firstNode == null); }
    
    /**
     * Recursively add a new node into tree through existing node's.
     * 
     * @param reader
     */
    public void insert(ReaderNode reader) {
        if (this.firstNode == null) {
            this.firstNode = reader;
        } else {
            insertNode(this.firstNode, reader);
        }
    }
    
    private void insertNode(ReaderNode parent, ReaderNode node) {
        if (parent == null) {
            parent = node;
        } else if (parent.compare(node) == ReaderNode.COMP_LEFT) {
            if (parent.isFreeLeft()) {
                parent.setLeft(node);
            } else {
                insertNode(parent.left(), node);
            }
        } else if (parent.compare(node) == ReaderNode.COMP_RIGHT) {
            if (parent.isFreeRight()) {
                parent.setRight(node);
            } else {
                insertNode(parent.right(), node);
            }
        }
    }
    
    public void delete(int readerCode) {
        this.firstNode = deleteRecursive(firstNode, readerCode);
    }
    
    private ReaderNode deleteRecursive(ReaderNode node, int readerCode) {
        if (node == null) {
            return node;
        }
        
        if (readerCode < node.getReader().getComparableCode()) {
            node.setLeft(deleteRecursive(node.left(), readerCode));
        } else if (readerCode > node.getReader().getComparableCode()) {
            node.setRight(deleteRecursive(node.right(), readerCode));
        } else {
            if (node.isFreeLeft()) {
                return node.right();
            } else if (node.isFreeRight()) {
                return node.left();
            }
            node.setReader(
                this.getNode(
                    this.minCode(node.right())
                ).getReader()
            );
            node.setRight(deleteRecursive(node.right(), 
                                          node.getReader().getComparableCode()));
        }
        
        return node;
    }
    
    private int minCode(ReaderNode node) {
        int min = node.getReader().getComparableCode();
        ReaderNode temp = node;
        while (!temp.isFreeLeft()) {
            min = temp.getReader().getComparableCode();
            temp = temp.left(); 
        }
        return min; 
    }
    
    
    public ReaderNode getNode(int readerCode) {
        return findNode(this.firstNode, readerCode);
    }
    
    private ReaderNode findNode(ReaderNode node, int readerCode) {
        if (node == null) {
            return node;
        } 
        System.out.println("Finding: ");
        System.out.println(node.getReader().getComparableCode());
        if (node.getReader().getComparableCode() == readerCode) {
            System.out.println("Found");
            return node;
        } else {
            if (node.getReader().getComparableCode() < readerCode) {
                return findNode(node.right(), readerCode);
            } else if (node.getReader().getComparableCode() > readerCode) {
                return findNode(node.left(), readerCode);
            } else return null;
        }
    }
    
    public ArrayList<ReaderNode> toArrayList() {
        ArrayList<ReaderNode> list = new ArrayList();
        createNodesList(list, this.firstNode);
        return list;
    }
    
    private void createNodesList(ArrayList<ReaderNode> list, ReaderNode node) {
        if (node != null) {
            createNodesList(list, node.left());
            list.add(node);
            createNodesList(list, node.right());
        }
    }
    
    
}
